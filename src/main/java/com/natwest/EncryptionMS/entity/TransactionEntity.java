package com.natwest.EncryptionMS.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TransactionEntity {
	
	@NotNull(message = "Account number should not be null")
	@NotEmpty(message = "Account number can not be empty")
	@Pattern(regexp="^[0-9]*$", message = "Account number can not have characters other than digits")
	private String accountNumber;
	
	@NotNull(message = "Account type should not be null")
	@NotEmpty(message = "Account type can not be empty")
	private String type;
	
	@NotNull(message = "Amount should not be null")
	@NotEmpty(message = "Amount can not be empty")
	@Pattern(regexp="^[1-9]\\d*$", message = "Amount invalid")
	private String amount;
	
	@NotNull(message = "Currency should not be null")
	@NotEmpty(message = "Currency can not be empty")
	private String currency;
	
	@NotNull(message = "From Account should not be null")
	@NotEmpty(message = "From Account can not be empty")
	@Pattern(regexp="^[0-9]*$", message = "From Account number can not have characters other than digits")
	private String accountFrom;

	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionEntity(String accountNumber, String type, String amount, String currency, String accountFrom) {
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	@Override
	public String toString() {
		return "Transaction [accountNumber=" + accountNumber + ", type=" + type + ", amount=" + amount + ", currency="
				+ currency + ", accountFrom=" + accountFrom + "]";
	}
	
	
}
