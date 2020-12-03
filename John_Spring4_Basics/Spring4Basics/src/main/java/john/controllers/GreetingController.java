package john.controllers;

import org.springframework.beans.factory.annotation.Value;

import john.service.HelloWorldService;

//@Controller
public class GreetingController {
	
//	@Autowired
	private HelloWorldService helloService;	
	

//	@Value("${app.name}")
//	private String appName;

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
