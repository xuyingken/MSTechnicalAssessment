package com.microservices.domain;


public class CustomerAccount {

	private String customerId;
	private String accountNumber;
	
	private String accountName;
	private String accountType;
	private String balance;
	private String currency;


	public CustomerAccount() {
	}

	public CustomerAccount(String accountNumber, String accountName, String accountType, String balance, String currency,
			String customerId) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balance = balance;
		this.currency = currency;
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		return "Customer [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountType="
				+ accountType + ", balance=" + balance + ", currency=" + currency + ", customerId=" + customerId + "]";
	}

}
