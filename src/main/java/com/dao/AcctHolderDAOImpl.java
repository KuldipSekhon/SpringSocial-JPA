package com.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.model.Account;
import com.model.AccountHolder;
import com.utilities.HibernateFactory;

import facebook4j.internal.logging.Logger;


@Service("AcctHolderDAO")
public class AcctHolderDAOImpl implements AcctHolderDAO{

   Logger logg = Logger.getLogger(AcctHolderDAOImpl.class);
	
	private SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
	
	
	
	@Override
	public void enterAccountDetails(Account account) {
	
		  logg.info("before Saving the Account Entity..");
		  
		//  Session sess = sessionFactory.getCurrentSession();
		  
		  Session sess1 = null;
		  
		//  if(sess==null){
			   sess1 = sessionFactory.openSession();
		//  }
			   
			   sess1.save(account);
		  
		  logg.info("Value for session object sess1 is:::::::::"+sess1.toString());
		  
		//  logg.info("Value for session object sess is:::::::::"+sess.toString());
		  
		  
		 // sessionFactory.getCurrentSession().save(accountHolder);
		
		
		
		
		
	}

}
