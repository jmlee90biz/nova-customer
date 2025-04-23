package com.sktelecom.nova.customer.subscription.internal;

//import com.sktelecom.nova.common.notification.event.NotificationRequestedEvent;
import com.sktelecom.nova.customer.subscription.api.SubscriptionCustomerProductPricingPlanDto;
import com.sktelecom.nova.customer.subscription.api.SubscriptionService;
import com.sktelecom.nova.customer.subscription.event.SubscriptionActivatedEvent;

import lombok.RequiredArgsConstructor;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionEventListener {
    private final SubscriptionService subscriptionService;

//    @Async("taskExecutor")
//    @ApplicationModuleListener
//    void onSubscriptionActivatedEvent(final SubscriptionActivatedEvent subscriptionActivatedEvent) {
//        SubscriptionCustomerProductPricingPlanDto subscriptionCustomerProductPricingPlanDto =
//                subscriptionService.findSubscriptionCustomerProductPricingPlanById(subscriptionActivatedEvent.id());
//
//        eventPublisher.publish(
//                NotificationRequestedEvent.create(
//                        subscriptionCustomerProductPricingPlanDto.customerEmail(),
//                        "Subscription Activated",
//                        subscriptionCustomerProductPricingPlanDto.productName() + " " +
//                                subscriptionCustomerProductPricingPlanDto.pricingPlanName()
//                )
//        );
//    }
}
