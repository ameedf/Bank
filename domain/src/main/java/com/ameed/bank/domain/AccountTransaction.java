package com.ameed.bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions", schema = "bank")
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String type;
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public AccountTransaction() {
	}

	public AccountTransaction(Account account, String type, Double amount) {
		this.account = account;
		this.type = type;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
