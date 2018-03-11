package com.ameed.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ameed.bank.domain.Account;
import com.ameed.bank.domain.AccountTransaction;
import com.ameed.services.api.AccountTransactionsService;
import com.ameed.services.api.AccountsService;

@Stateless(mappedName = "transactions")
public class AccountTransactionsServiceImpl implements AccountTransactionsService {

	@PersistenceContext(unitName = "bank-pu")
	private EntityManager em;

	@EJB
	private AccountsService accountsService;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public AccountTransaction createAccountTransaction(String accountOwner, String type, double amount) {
		Account account = accountsService.findOrCreateAccount(accountOwner);
		AccountTransaction tr = new AccountTransaction(account, type, amount);
		em.persist(tr);
		return tr;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public List<AccountTransaction> findAll() {
		TypedQuery<AccountTransaction> query = em.createQuery("select t from AccountTransaction t",
				AccountTransaction.class);
		return query.getResultList();
	}
}
