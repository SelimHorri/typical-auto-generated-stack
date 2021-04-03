package com.selimhorri.pack;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.selimhorri.pack");

        noClasses()
            .that()
            .resideInAnyPackage("com.selimhorri.pack.service..")
            .or()
            .resideInAnyPackage("com.selimhorri.pack.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.selimhorri.pack.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
