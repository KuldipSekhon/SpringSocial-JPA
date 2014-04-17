package com.model;

/**
 * Created by akhilg on 17/4/14.
 */


public class Account {
    private int account_id;
    private AccountType accountType;

    Account(int account_id,AccountType accountType){
        this.account_id = account_id;
        this.accountType = accountType;
    }

}
