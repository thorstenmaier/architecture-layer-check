package com.trivadis.architecture.demo.controller;

import com.trivadis.architecture.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoController {

	@Autowired
	private DemoService demoService;

	public void doSomethingInController() {

	}
}
