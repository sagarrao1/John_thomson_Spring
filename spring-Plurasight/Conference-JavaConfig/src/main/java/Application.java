import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.plurasight.model.Speaker;
import com.plurasight.service.SpeakerService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext= 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
//		SpeakerService service = new SpeakerServiceImpl();
		SpeakerService service =  appContext.getBean("speakerService",SpeakerService.class);
		
//		to test bean scope singleton vs prorotype
		System.out.println(service);
				
		List<Speaker> list = service.findAll();
		
		for (Speaker speaker : list) {
			System.out.println(speaker.getFirstName());
		}
		
		SpeakerService service2 =  appContext.getBean("speakerService",SpeakerService.class);
		
//		to test bean scope singleton vs prorotype
		System.out.println(service2);
		
	}

}
