package com.sktelecom.nova.customer.profilehx.contract.api;


import java.util.List;
import java.util.UUID;

public interface CustomerProfileService {
    CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
    CustomerDto getCustomerById(UUID customerId);
    List<CustomerDto> findAllCustomers();
}
