package com.trivadis.architecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @Filter(type = FilterType.REGEX, pattern = { ".*ServiceImpl", ".*Controller" }), basePackages = { "com.trivadis.architecture.demo" })
public class DependencyTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyTesterApplication.class, args);
	}

	@Autowired
	public void createDotFile(DefaultListableBeanFactory beanFactory) {
		System.out.println("\n\ndigraph {");
		for (String beanName : beanFactory.getBeanDefinitionNames()) {
			if (beanFactory.getBean(beanName).getClass().getPackageName().startsWith("com.trivadis")) {
				for (String depName : beanFactory.getDependenciesForBean(beanName)) {
					System.out.println("\t" + beanName + " -> " + depName);
				}
			}
		}
		System.out.println("}\n\n");
	}
}
