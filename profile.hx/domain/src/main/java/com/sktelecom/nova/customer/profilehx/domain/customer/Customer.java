package com.sktelecom.nova.customer.profilehx.domain.customer;

import com.sktelecom.nova.customer.profile.event.CustomerRegisteredEvent;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
class Customer {
    private UUID id;

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    static Customer createCustomer(String name, String email) {
        return new Customer(name, email);
    }

    CustomerRegisteredEvent createCustomerRegisteredEvent() {
        return new CustomerRegisteredEvent(this.getId(), this.getName(), this.getEmail());
    }

}