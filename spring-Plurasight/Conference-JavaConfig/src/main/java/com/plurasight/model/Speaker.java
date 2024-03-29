package com.plurasight.model;

import org.springframework.stereotype.Component;

@Component
public class Speaker {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Speaker(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Speaker [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Speaker() {
		super();
	}

	
	
}
