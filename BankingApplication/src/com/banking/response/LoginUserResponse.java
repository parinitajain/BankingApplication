package com.banking.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"message"})
public class LoginUserResponse implements Serializable{

	private static final long serialVersionUID = 4083285363245907410L;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

}
