package john.service;

public class HelloWorldFactory {
	
	
	public HelloWorldService createHelloWService(String language) {
		HelloWorldService service= null;
		
		
		switch (language) {
		case "en":
			service= new HelloWorldServiceEnglishImpl();
			break;

		case "es":
			service= new HelloWorldServiceSpanishImpl();
			break;

		default:
			new HelloWorldServiceEnglishImpl();
		}
		return service;
	}

}
