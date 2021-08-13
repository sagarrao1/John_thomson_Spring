package com.plurasight.repository;

import java.util.List;

import com.plurasight.model.Speaker;

public interface SpeakerRepository {

	List<Speaker> findAll();

}