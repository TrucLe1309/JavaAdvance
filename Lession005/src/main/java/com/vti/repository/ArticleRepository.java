package com.vti.repository;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class ArticleRepository {
    private HibernateUtils hibernateUtils;

    public ArticleRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createArticle(Article article) {
        Session session = null;
        Transaction transaction = null;

        try {

            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();

            session.save(article);

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Article> getListArticles() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("FROM Article");
            return  query.list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Article getListArticleByTitle(String title) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("SELECT atc FROM Article atc WHERE title = :titlePramater");
            query.setParameter("titlePramater", title);
            return  query.uniqueResult();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateArticle(String id, String title) {
        Session session = null;
        Transaction transaction = null;

        try {

            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();

            UUID uid = UUID.fromString("b9697eeb-96a7-46b9-ac99-20db531f68ce");
            Article atc = session.get(Article.class, uid);
            atc.setTitle(title);
            UUID idResult = (UUID)session.save(atc);
            System.out.println("uid result: " + idResult);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteArticle(int id) {
        Session session = null;
        Transaction transaction = null;

        try {

            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();

            UUID uid = UUID.fromString("b9697eeb-96a7-46b9-ac99-20db531f68ce");

            Article atc = session.get(Article.class, id);

            session.delete(atc);

            //UUID idResult = (UUID)session.delete(atc);

            //System.out.println("uid result: " + idResult);

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }



}
