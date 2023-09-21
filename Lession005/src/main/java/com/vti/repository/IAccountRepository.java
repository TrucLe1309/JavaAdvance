package com.vti.repository;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountRepository {
    void addNewAccount(Account ac);
    List<Account> getListAccounts();

    void deleteAccount(int id);

    void updateAccount(Account ac);
}
