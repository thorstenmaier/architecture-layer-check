package de.oio.architecture.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import de.oio.architecture.demo.service.DemoService;

public class DemoController {

	@Autowired
	private DemoService demoService;

	public void doSomethingInController() {

	}
}
