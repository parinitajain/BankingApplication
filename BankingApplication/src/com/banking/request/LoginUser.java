package com.banking.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"username","password"})
public class LoginUser implements Serializable{

	private static final long serialVersionUID = 4083285363245907410L;
	
	@JsonProperty("username")
	private int userName;
	
	@JsonProperty("password")
	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}
	
	
	

}
