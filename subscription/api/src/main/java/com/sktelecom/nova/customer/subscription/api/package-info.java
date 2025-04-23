@ApplicationModule(
        displayName="customer-subscription-api",
        allowedDependencies = {
                "customer.profile.api",
                "product.pricing.api"
        }
)
package com.sktelecom.nova.customer.subscription.api;

import org.springframework.modulith.ApplicationModule;
