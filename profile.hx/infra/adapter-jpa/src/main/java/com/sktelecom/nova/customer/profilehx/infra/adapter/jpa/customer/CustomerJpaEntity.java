package com.sktelecom.nova.customer.profilehx.infra.adapter.jpa.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer", schema = "customer")
class CustomerJpaEntity {
    @Id
    private UUID id;

    private String name;
    private String email;

    public CustomerJpaEntity(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

}