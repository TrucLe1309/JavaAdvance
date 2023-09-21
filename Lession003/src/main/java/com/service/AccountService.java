package com.service;

import com.repository.AccountRepository;

public class AccountService implements IAccountService{
    private AccountRepository accountRepository;
    public AccountService(){
        accountRepository = new AccountRepository();
    }


    }


}
