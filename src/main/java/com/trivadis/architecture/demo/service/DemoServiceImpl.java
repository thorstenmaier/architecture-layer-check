package com.trivadis.architecture.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.trivadis.architecture.demo.controller.DemoController;

public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoController demoController; // not allowed!

	public void doSomethingInService() {
		demoController.doSomethingInController();
	}

}
