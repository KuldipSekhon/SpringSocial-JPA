package com.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.AcctHolderDAO;
import com.dao.AcctHolderDAOImpl;

import com.model.Account;


@Service("AccountService")
public class AccountServiceImpl implements AccountService{
	
	private  AcctHolderDAO acctHolderDAO;
	
	@Autowired
	public AccountServiceImpl(AcctHolderDAO acctHolderDAO){
		super();
		this.acctHolderDAO = acctHolderDAO;
	}

	
    protected static final Logger logg = Logger.getLogger(AccountServiceImpl.class.getName());
	
	public void enterAccountDetails(Account account) {
		
		logg.info("Inside AccountService Impl..............");
		 acctHolderDAO.enterAccountDetails(account);
		
		
	}
	
	

}
