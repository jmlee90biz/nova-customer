package com.sktelecom.nova.customer.profile.client;

import com.sktelecom.nova.customer.profile.api.CustomerDto;
import com.sktelecom.nova.customer.profile.api.CustomerProfileService;
import com.sktelecom.nova.customer.profile.api.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerProfileServiceClient implements CustomerProfileService {
    private final CustomerProfileServiceFeignClient client;

    @Override
    public CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        return client.registerCustomer(customerRegistrationRequest);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return client.getCustomerById(customerId);
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return client.findAllCustomers();
    }
}
