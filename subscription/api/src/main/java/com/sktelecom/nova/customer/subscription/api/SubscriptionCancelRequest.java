package com.sktelecom.nova.customer.subscription.api;

import java.util.UUID;

public record SubscriptionCancelRequest(UUID customerId, UUID pricingPlanId) {
}