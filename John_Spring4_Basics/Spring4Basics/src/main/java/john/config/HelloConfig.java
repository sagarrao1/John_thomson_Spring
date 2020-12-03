package john.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import john.service.HelloWorldFactory;
import john.service.HelloWorldService;

//@Configuration
public class HelloConfig {
	
//	@Bean	
//	public HelloWorldFactory creatFactory() {
//		return new HelloWorldFactory();
//	}	
	
	
//	@Bean
//	@Profile("english")
//	public HelloWorldService helloWorldServiceEnglishImpl(HelloWorldFactory factory) {
////		return new HelloWorldServiceEnglishImpl();
//		return factory.createHelloWService("en");
//		
//	}
	
//	@Bean
//	@Profile("spanish")
//	public HelloWorldService helloWorldServiceSpanishImpl(HelloWorldFactory factory) {
////		return new HelloWorldServiceSpanishImpl();
//		return factory.createHelloWService("es");
//		
//	}

}
