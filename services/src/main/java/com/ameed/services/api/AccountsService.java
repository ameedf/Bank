package com.ameed.services.api;

import javax.ejb.Local;

import com.ameed.bank.domain.Account;

@Local
public interface AccountsService {
	Account findOrCreateAccount(String accountOwner);
}
