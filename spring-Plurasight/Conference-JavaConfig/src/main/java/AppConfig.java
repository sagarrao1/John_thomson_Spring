import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.plurasight"})
public class AppConfig {
/*	
	@Bean(name = "speakerService")
	@Scope(value = BeanDefinition.SCOPE_SINGLETON)
//	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public SpeakerService getSpeakerService() {
//		used for setter injection
		 SpeakerServiceImpl service= new SpeakerServiceImpl();		 
		
//		using constructor injection
//		SpeakerServiceImpl service= new SpeakerServiceImpl(getSpeakerRepository());
		
		
//		used for setter injection
//		service.setRepository(getSpeakerRepository());	

		
		return service;
	}
	
	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new HibernateSpeakerRepositoryImpl();
	}
 */
}
