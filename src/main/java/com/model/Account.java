package com.model;

/**
 * Created by akhilg on 17/4/14.
 */

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.cfg.Configuration;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id @GeneratedValue
	@Column(name="ACCOUNT_ID")
    private int account_id;
    @Column(name="ACCOUNT_NAME")
    private String account_name;
    private AccountType accountType;

    Account(int account_id,AccountType accountType,String account_name){
        this.account_id = account_id;
        this.accountType = accountType;
        this.account_name = account_name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

}
