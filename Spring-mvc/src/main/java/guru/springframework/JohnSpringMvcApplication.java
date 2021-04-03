package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JohnSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JohnSpringMvcApplication.class, args);
		
//		System.out.println("Beans ******************");
		System.out.println("Bean count:"+ ctx.getBeanDefinitionCount());
//		
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
//		System.out.println("Beans End******************");
//		
//		 List<String> beans =Arrays.asList(ctx.getBeanDefinitionNames());
//		
//		for (int i = 0; i < beans.size(); i++) {
//			System.out.println(beans.get(i));
//			
//		}
		
	}

}
