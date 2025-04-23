package com.sktelecom.nova.customer.subscription.api;

import java.util.UUID;

public record SubscriptionActivateRequest(UUID customerId, UUID pricingPlanId) {
}