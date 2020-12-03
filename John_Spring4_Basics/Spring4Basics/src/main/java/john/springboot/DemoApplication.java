package john.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import john.controllers.GreetingController;

@SpringBootApplication
//@ComponentScan("john")
@ImportResource("classpath:/spring/spring-config.xml")
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        GreetingController controller= ctx.getBean("greetingController", GreetingController.class);

        controller.greet();
        
    }
}
