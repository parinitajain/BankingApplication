package com.banking.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "accountNumber", "balance"})
public class UserAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3264265995735170012L;
	
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("balance")
	private float balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
