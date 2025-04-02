package com.sktelecom.nova.customer;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
public class NovaCustomerServiceTest {
    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of("com.sktelecom.nova.customer");

        modules.forEach(System.out::println);

        //modules.verify();
    }
}
