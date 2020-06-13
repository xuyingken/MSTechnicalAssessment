package com.microservices.domain;

public class Customer {

	private String customerId;
	private String accountName;
	private String accountType;
	private String balance;
	private String currency;


	public Customer() {
	}

	public Customer( String accountName, String accountType, String balance, String currency,
			String customerId) {
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.balance = balance;
		this.currency = currency;
		this.customerId = customerId;
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [accountName=" + accountName + ", accountType="
				+ accountType + ", balance=" + balance + ", currency=" + currency + ", customerId=" + customerId + "]";
	}

}
