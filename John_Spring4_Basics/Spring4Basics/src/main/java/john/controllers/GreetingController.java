package john.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import john.service.HelloWorldService;

//@Controller
public class GreetingController {
	
//	@Autowired
	private HelloWorldService helloService;	

	public String greet() {		
		String greeting = helloService.getGreeting();
		System.out.println(greeting);
		return greeting;		
	}

	public HelloWorldService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloWorldService helloService) {
		this.helloService = helloService;
	}
	
	
	
	
	
}
