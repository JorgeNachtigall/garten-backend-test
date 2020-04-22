package org.niko.mywebapp;

public enum Status {

	SUCCESS("Success"),
	ERROR("Error");
	
	public String status;
	
	Status(String message){
		this.status = message;
	}
	
}
