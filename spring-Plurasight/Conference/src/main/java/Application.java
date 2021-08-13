import java.util.List;

import com.plurasight.model.Speaker;
import com.plurasight.service.SpeakerService;
import com.plurasight.service.SpeakerServiceImpl;

public class Application {

	public static void main(String[] args) {
		SpeakerService service = new SpeakerServiceImpl();

		List<Speaker> list = service.findAll();
		
		for (Speaker speaker : list) {
			System.out.println(speaker.getFirstName());
		}
	}

}
