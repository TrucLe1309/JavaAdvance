package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository implements IAccountRepository{
    private HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
        //Temporary connection to create or update table
        //hibernateUtils.openSession();
    }

    @Override
    public void addNewAccount(Account ac) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(ac);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Account> getListAccounts() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            //Tạo câu truy vấn HQL từ phiên làm việc session
            Query<Account> query = session.createQuery("FROM Account") ;
            return query.list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Account findAccountByUsername(String username) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Account> query = session.createQuery("SELECT ac FROM Account ac WHERE username =:usernameParameter") ;
            query.setParameter("usernameParameter", username);
            return query.uniqueResult();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteAccount(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
//            Khi gửi câu lệnh xuống thì đảm bảo tất cả được thực hiện
//            nếu không nó sẽ rollback lại tất cả dữ liệu
            transaction.begin();

            Account ac = session.get(Account.class, id);
            session.delete(ac);

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateAccount(Account ac) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Account oldAc = session.get(Account.class, ac.getId());
            oldAc.setFirstName(ac.getFirstName());
            oldAc.setLastName(ac.getLastName());
            oldAc.setUsername(ac.getUsername());
            oldAc.setPassword(ac.getPassword());
            oldAc.setRole(ac.getRole());
            session.save(oldAc);

            transaction.commit();// thực thi câu lệnh
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
