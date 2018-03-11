package com.ameed.bank.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ameed.bank.domain.AccountTransaction;
import com.ameed.services.api.AccountTransactionsService;

@Path("/transaction")
public class TransactionsController {
	
	@EJB(name = "transactions")
	private AccountTransactionsService transactions;
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountTransaction> listAll() {
		return transactions.findAll();
	}
}
