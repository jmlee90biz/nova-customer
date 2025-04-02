@ApplicationModule(
        displayName = "customer-subscription-internal",
        allowedDependencies = {
                "customer.profile.api",
                "customer.event.api",
                "product.pricing.api",

                //"common.notification::event"
        }
)
package com.sktelecom.nova.subscription.internal;

import org.springframework.modulith.ApplicationModule;