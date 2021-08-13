package com.plurasight.service;

import java.util.List;

import com.plurasight.model.Speaker;
import com.plurasight.repository.HibernateSpeakerRepositoryImpl;
import com.plurasight.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository=  new HibernateSpeakerRepositoryImpl();
	
	@Override
	public List<Speaker> findAll() {
		
		return repository.findAll();
	}
}
