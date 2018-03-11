package com.ameed.services.api;

import java.util.List;

import javax.ejb.Local;

import com.ameed.bank.domain.AccountTransaction;

@Local
public interface AccountTransactionsService {
	AccountTransaction createAccountTransaction(String accountOwner, String type, double amount);

	List<AccountTransaction> findAll();
}
