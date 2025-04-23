package com.sktelecom.nova;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
public class NovaCustomerServiceTest {
    @Test
    void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(NovaCustomerService.class);

        modules.forEach(System.out::println);

        modules.verify();
    }

    @Test
    void documentation() {
        new Documenter(ApplicationModules.of(NovaCustomerService.class))
                .writeDocumentation()
                .writeAggregatingDocument()
                .writeModulesAsPlantUml(Documenter.DiagramOptions.defaults()
                        .withStyle(Documenter.DiagramOptions.DiagramStyle.UML))
                .writeIndividualModulesAsPlantUml(Documenter.DiagramOptions.defaults()
                        .withStyle(Documenter.DiagramOptions.DiagramStyle.UML))
                .writeModuleCanvases();

        Documenter.DiagramOptions.defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.UML);
    }

}
