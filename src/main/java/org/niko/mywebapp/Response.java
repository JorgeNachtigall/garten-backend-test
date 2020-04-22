package org.niko.mywebapp;

import com.google.gson.JsonElement;

public class Response {
	
	private Status status;
	private String message;
	private JsonElement data;
	
	public Response(Status status) {
		this.status = status;
	}
	
	public Response(Status status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Response(Status status, JsonElement data) {
		this.status = status;
		this.data = data;
	}
	
}
