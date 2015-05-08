package de.oio.architecture;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DepencencyTesterApplication.class)
public class DepencencyTesterApplicationTests {

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
