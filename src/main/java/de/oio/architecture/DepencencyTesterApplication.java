package de.oio.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(includeFilters = @Filter(type = FilterType.REGEX, pattern = { ".*ServiceImpl", ".*Controller" }), basePackages = { "de.oio.architecture.demo" })
public class DepencencyTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepencencyTesterApplication.class, args);
	}
}
