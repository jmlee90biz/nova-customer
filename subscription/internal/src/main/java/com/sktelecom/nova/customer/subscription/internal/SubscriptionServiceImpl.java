package com.sktelecom.nova.customer.subscription.internal;

import com.sktelecom.nova.customer.profile.api.CustomerDto;
import com.sktelecom.nova.customer.profile.api.CustomerProfileService;

import com.sktelecom.nova.customer.subscription.api.SubscriptionActivateRequest;
import com.sktelecom.nova.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.customer.subscription.api.SubscriptionDto;
import com.sktelecom.nova.customer.subscription.api.SubscriptionService;
import com.sktelecom.nova.product.pricing.api.ProductPricingPlanDto;
import com.sktelecom.nova.product.pricing.api.ProductPricingService;
import com.sktelecom.nova.shared.util.JoinUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    private final CustomerProfileService customerProfileService;
    private final ProductPricingService productPricingService;

    private final ApplicationEventPublisher eventPublisher;


    @Override
    public SubscriptionCustomerProductPricingPlanDto findSubscriptionCustomerProductPricingPlanById(UUID subscriptionId) {
        SubscriptionDto subscriptionDto = getSubscriptionById(subscriptionId);
        CustomerDto customer = customerProfileService.getCustomerById(subscriptionDto.customerId());
        ProductPricingPlanDto productPricingPlanDto = productPricingService.findProductPricingPlanById(subscriptionDto.pricingPlanId());

        return SubscriptionCustomerProductPricingPlanDto.join(productPricingPlanDto,
                SubscriptionCustomerProductPricingPlanDto.join(customer, subscriptionDto));
    }


    @Override
    @Transactional
    public SubscriptionDto activateSubscription(SubscriptionActivateRequest subscriptionActivateRequest) {
        Subscription activatedSubscription = subscriptionRepository.save(
                Subscription.createActivatedSubscription(subscriptionActivateRequest.customerId(), subscriptionActivateRequest.pricingPlanId())
        );

        SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto =
                findSubscriptionCustomerProductPricingPlanById(activatedSubscription.getId());

        eventPublisher.publishEvent(activatedSubscription.createSubscriptionActivatedEvent(subscriptionCustomerProductPricingPlanDto));

        System.out.println("SUBSCRIPTION ACTIVED: " + activatedSubscription);
        return SubscriptionMapper.toSubscriptionDto(activatedSubscription);
    }

    @Override
    public SubscriptionDto getSubscriptionById(UUID customerId) {
        return subscriptionRepository.findById(customerId).map(SubscriptionMapper::toSubscriptionDto)
                .orElseThrow(()->new RuntimeException("Subscription not found"));
    }

    @Override
    public List<SubscriptionDto> findAllSubscriptions() {
        return subscriptionRepository.findAll().stream().map(SubscriptionMapper::toSubscriptionDto).toList();
    }

    @Override
    public List<SubscriptionCustomerProductPricingPlanDto> findAllSubscriptionCustomerProductPricingPlans() {
        List<SubscriptionDto> subscriptionDtos = findAllSubscriptions();
        List<CustomerDto> customers = customerProfileService.findAllCustomers();
        List<ProductPricingPlanDto> productPricingPlans = productPricingService.findAllProductPricingPlans();

        List<SubscriptionCustomerProductPricingPlanDto> subscriptionCustomerProductPricingPlanDtos =
                JoinUtil.<UUID, CustomerDto, SubscriptionDto, SubscriptionCustomerProductPricingPlanDto>joinLists(
                        customers, CustomerDto::id,
                        subscriptionDtos, SubscriptionDto::customerId,
                        SubscriptionCustomerProductPricingPlanDto::join
                );

        return JoinUtil.<UUID, ProductPricingPlanDto, SubscriptionCustomerProductPricingPlanDto, SubscriptionCustomerProductPricingPlanDto>joinLists(
                productPricingPlans, ProductPricingPlanDto::id,
                subscriptionCustomerProductPricingPlanDtos, SubscriptionCustomerProductPricingPlanDto::pricingPlanId,
                SubscriptionCustomerProductPricingPlanDto::join
        );
    }


}
