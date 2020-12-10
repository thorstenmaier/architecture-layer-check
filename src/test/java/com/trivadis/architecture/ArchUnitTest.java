package com.trivadis.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "de.oio.architecture")
public class ArchUnitTest {

	@ArchTest
	public static final ArchRule myRule1 = noClasses().that().haveNameMatching(".*ServiceImpl").should()
			.accessClassesThat().haveNameMatching(".*Controller");

}
