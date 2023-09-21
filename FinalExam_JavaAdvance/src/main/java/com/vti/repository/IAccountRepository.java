package com.vti.repository;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountRepository {
    void addNewAccount(Account ac);
    List<Account> getListAccounts();

    Account findAccountByUsername(String username);

    void deleteAccount(int id);

    void updateAccount(Account ac);
}
