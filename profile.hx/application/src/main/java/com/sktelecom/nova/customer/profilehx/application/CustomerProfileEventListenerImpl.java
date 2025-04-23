package com.sktelecom.nova.customer.profilehx.application;

//import com.sktelecom.nova.modular.monolith.common.notification.event.NotificationRequestedEvent;

import com.sktelecom.nova.customer.profilehx.contract.api.CustomerProfileService;
import com.sktelecom.nova.customer.profilehx.contract.event.CustomerRegisteredEvent;
import com.sktelecom.nova.customer.profilehx.contract.event.CustomerRegisteredEventListener;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerProfileEventListenerImpl implements CustomerRegisteredEventListener {
    private final CustomerProfileService customerProfileService;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void onCustomerRegisteredEvent(CustomerRegisteredEvent event) {

    }
}
