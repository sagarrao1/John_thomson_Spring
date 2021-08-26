package com.plurasight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plurasight.model.Speaker;
import com.plurasight.repository.SpeakerRepository;

@Service(value = "speakerService")
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	private SpeakerRepository repository;
	
	@Override
	public List<Speaker> findAll() {
		
		return repository.findAll();
	}

	
	public SpeakerServiceImpl() {
		System.out.println("SpeakerServiceImpl no arg constructor");
	}

	
	public void setRepository(SpeakerRepository repository) {
		System.out.println("SpeakerServiceImpl setter");
		this.repository = repository;
	}

	
	public SpeakerServiceImpl(SpeakerRepository repository) {
		System.out.println("SpeakerServiceImpl one arg constructor");
		this.repository = repository;
	}
	
	
	
	
	
}
