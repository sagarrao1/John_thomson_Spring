package com.plurasight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.plurasight.model.Speaker;

@Repository(value = "speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

	@Override
	public List<Speaker> findAll(){
		
		List<Speaker> speakers = new ArrayList<>();
		
		Speaker s1= new Speaker("Sagar","Rao");
		Speaker s2= new Speaker("John","ceena");
		Speaker s3= new Speaker("Srinath","vardineni");
		
		speakers.add(s1);
		speakers.add(s2);
		speakers.add(s3);
		
		return speakers;
	} 
}
