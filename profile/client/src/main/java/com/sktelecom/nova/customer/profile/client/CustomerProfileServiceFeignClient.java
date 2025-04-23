package com.sktelecom.nova.customer.profile.client;

import com.sktelecom.nova.customer.profile.api.CustomerDto;
import com.sktelecom.nova.customer.profile.api.CustomerRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "customer-profile",
        url = "http://localhost:8082"
)
public interface CustomerProfileServiceFeignClient {
    @PostMapping("/customer/profile/customers")
    CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);

    @GetMapping("/customer/profile/customers/{id}")
    CustomerDto getCustomerById(@PathVariable("id") UUID customerId);

    @GetMapping("/customer/profile/customers")
    List<CustomerDto> findAllCustomers();
}
