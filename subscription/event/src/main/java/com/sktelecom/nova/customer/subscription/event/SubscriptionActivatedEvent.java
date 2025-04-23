package com.sktelecom.nova.customer.subscription.event;

import java.math.BigDecimal;
import java.util.UUID;

public record SubscriptionActivatedEvent(
//        UUID id, UUID customerId, UUID pricingPlanId, SubscriptionStatus subscriptionStatus
        UUID id, String subscriptionStatus,
        UUID customerId, String customerName, String customerEmail,
        UUID pricingPlanId, UUID productId, String productName, String productDescription, String pricingPlanName, BigDecimal price
) {

}
