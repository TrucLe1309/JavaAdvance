package com.repository;

import com.entity.Account;
import com.utils.HibernateUtils;
import org.hibernate.Session;

public class AccountRepository implements IAccountRepository{
    private HibernateUtils hibernateUtils;
    public AccountRepository(){
        hibernateUtils= HibernateUtils.getInstance();

    }

    @Override
    public void addNewAccount(Account ac) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.save(ac);
        }finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
    }
    }

