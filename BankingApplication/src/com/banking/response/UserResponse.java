package com.banking.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "username","accountNumber","message","balance"})
public class UserResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8772288443653696879L;

	@JsonProperty("username")
	private int username;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("message")
	private String message;
	@JsonProperty("balance")
	private float balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	
	
	

	

}
