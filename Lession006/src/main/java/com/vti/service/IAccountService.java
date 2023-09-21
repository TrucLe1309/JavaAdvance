package com.vti.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    void addNewAccount(Account ac);

    List<Account> getListAccounts();

    void deleteAccount(int id);

    void updateAccount(Account ac);
}
