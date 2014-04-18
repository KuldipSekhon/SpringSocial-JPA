package com.common;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.model.AccountHolder;
import com.services.AccountService;
import com.services.AccountServiceImpl;

@Controller
public class AccountController extends MultiActionController{
	
	
	
	
	private AccountServiceImpl accountServiceImpl;
	//private AccountHolder accountHolder;
	
	@Autowired
	public AccountController(AccountServiceImpl accountServiceImpl){
	
		this.accountServiceImpl = accountServiceImpl;
		//this.accountHolder = accountHolder;
	}
	
	private AccountHolder accountHolder = new AccountHolder();
	
    protected static final Logger logg = Logger.getLogger(AccountController.class.getName());
	
	@RequestMapping(value="/enterAccountDtls/", method=RequestMethod.POST)
	public ModelAndView enterAccountDtls(ModelAndView modelAndView,HttpServletRequest
			request,HttpServletResponse response){
		 
		  // String name = request.getParameter("name");
		
		String name ="akkhil";
		   
		   logg.info("name form form is::::::"+name);
		   
		   accountHolder.setName(name);
		
		  accountServiceImpl.enterAccountDetails(accountHolder);
		  
		 // String name = accountHolder.getName();//???
		  //String accountType = accountHolder.g
		  
		  modelAndView.addObject("new_user",name);
		  
		  return modelAndView;
		
	}

}
