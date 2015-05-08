package de.oio.architecture.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import de.oio.architecture.demo.controller.DemoController;

public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoController demoController; // not allowed!

}
