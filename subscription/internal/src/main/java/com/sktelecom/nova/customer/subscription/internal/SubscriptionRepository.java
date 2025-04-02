package com.sktelecom.nova.subscription.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
}
