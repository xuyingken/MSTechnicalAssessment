package com.microservices.domain;
import javax.validation.constraints.Pattern;

public class CustomerAccountInput {
	
	@Pattern(regexp = "^(?![0-9]+$)[A-Za-z0-9 _-]{0,}$" , message = "SERVER_ERR001: Account name should not contain any special charecters and can not be all numbers!")
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
	@Override
	public String toString() {
		return "CustomerAccountInput [accountName=" + accountName + ", accountType=" + accountType + ", currency="
				+ currency + "]";
	}
	
}
