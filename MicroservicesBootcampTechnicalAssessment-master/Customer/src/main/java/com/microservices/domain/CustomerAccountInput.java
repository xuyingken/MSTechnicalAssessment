package com.microservices.domain;

public class CustomerAccountInput {
	private String accountName;
	private String accountType;
	private String currency;
	
	public CustomerAccountInput() {}
	public CustomerAccountInput(String accountName, String accountType, String currency) {
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.currency = currency;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
