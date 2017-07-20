package de.oio.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.junit.runner.RunWith;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.oio.architecture")
public class ArchUnitTest {

	@ArchTest
	public static final ArchRule myRule1 = noClasses().that().haveNameMatching(".*ServiceImpl").should()
			.accessClassesThat().haveNameMatching(".*Controller");

}
