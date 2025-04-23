@ApplicationModule(
        displayName = "customer-subscription-internal",
        allowedDependencies = {
                "customer.profile.api",
                "customer.subscription.api",
                "customer.subscription.event",
                "product.pricing.api",

                //"common.notification::event"
        }
)
package com.sktelecom.nova.customer.subscription.internal;

import org.springframework.modulith.ApplicationModule;