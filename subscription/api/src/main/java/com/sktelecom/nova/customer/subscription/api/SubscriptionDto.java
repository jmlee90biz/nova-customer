package com.sktelecom.nova.customer.subscription.api;

import java.util.UUID;

public record SubscriptionDto(UUID id, UUID customerId, UUID pricingPlanId, SubscriptionStatus subscriptionStatus) {
}
