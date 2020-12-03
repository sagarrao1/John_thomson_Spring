package john;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import john.controllers.GreetingController;
import john.springboot.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {
	
	@Autowired
	GreetingController greetingController;

	
	@Test
	public void contextLoads() {
		
		greetingController.getHelloService();
		
		String greet = greetingController.greet();
		assertEquals("Hello Mundo !!!", greet);
		
	}

}
