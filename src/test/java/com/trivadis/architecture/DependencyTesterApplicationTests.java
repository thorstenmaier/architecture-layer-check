package com.trivadis.architecture;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
public class DependencyTesterApplicationTests {

	@Autowired
	private DefaultListableBeanFactory beanFactory;

	@Test
	public void checkDependencies() {
		for (String beanName : beanFactory.getBeanDefinitionNames()) {
			for (String depName : beanFactory.getDependenciesForBean(beanName)) {
				checkNotAllowedConnection(beanName, depName, ".*ServiceImpl", ".*Controller");
			}
		}
	}

	private void checkNotAllowedConnection(String beanName, String depName, String beanNamePattern, String dependencyNamePattern) {
		String msg = "Connection not allowed: " + beanName + " -> " + depName;
		assertFalse(msg, beanName.matches(beanNamePattern) && depName.matches(dependencyNamePattern));
	}
}
