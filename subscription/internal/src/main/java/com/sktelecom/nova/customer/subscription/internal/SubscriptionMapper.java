package com.sktelecom.nova.customer.subscription.internal;

import com.sktelecom.nova.customer.subscription.api.SubscriptionDto;

class SubscriptionMapper {
    static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getCustomerId(),
                subscription.getPricingPlanId(),
                subscription.getSubscriptionStatus()
        );
    }
}
