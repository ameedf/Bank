package com.ameed.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ameed.bank.domain.Account;
import com.ameed.services.api.AccountsService;

@Stateless(mappedName = "accounts")
public class AccountsServiceImpl implements AccountsService {

	@PersistenceContext(unitName = "bank-pu")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Account findOrCreateAccount(String accountOwner) {
		Account account = findAccount(accountOwner);
		if (account != null) {
			return account;
		}
		return createAccount(accountOwner);
	}

	private Account findAccount(String accountOwner) {
		TypedQuery<Account> query = em.createQuery("select a from Account a where a.owner = :accountOwner", Account.class);
		query.setParameter("accountOwner", accountOwner);
		List<Account> list = query.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	private Account createAccount(String accountOwner) {
		Account account = new Account(accountOwner);
		em.persist(account);
		return account;
	}
}
