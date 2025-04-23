package com.sktelecom.nova.customer.profilehx.contract.event;

import java.util.UUID;

public record CustomerRegisteredEvent(UUID id, String name, String email) {
}
