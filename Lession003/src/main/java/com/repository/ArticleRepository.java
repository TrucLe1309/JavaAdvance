package com.repository;


import com.entity.Article;
import com.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ArticleRepository {
    private HibernateUtils hibernateUtils;

    public ArticleRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    public void createArticle(Article article){
        Session session = null;
        Transaction transaction = null;


        try {
            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();
            session.save(article);
            transaction.commit();
        }finally {
            if (session!= null){
                session.close();
            }
        }

    }

    public List<Article> getListArticles(){ //Phương thức read để lấy ra danh sách article
        // để show ra màn hình đang có bao nhiêu article tất cả

        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("FROM Article");
            return query.list();
        }finally {
            if (session!= null){
                session.close();
            }
        }

    }

    //phương thức getListArticleByTitle
    public Article getListArticlesByTitle(String title){ //Phương thức read để lấy ra danh sách article
        // để show ra màn hình đang có bao nhiêu article tất cả dựa trên title

        Session session = null;

        try {
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("SELECT atc FROM Article atc WHERE title = :titleParameter");
            query.setParameter("titleParameter", title);
            return query.uniqueResult();
        }finally {
            if (session!= null){
                session.close();
            }
        }

    }
    public void updateArticle(int id, String title){
        Session session = null;
        Transaction transaction = null;


        try {
            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();


            Article atc = session.get(Article.class, id);
            atc.setTitle(title);
            session.save(atc);

            transaction.commit();
        }finally {
            if (session!= null){
                session.close();
            }
        }

    }

    public void deleteArticle(int id){
        Session session = null;
        Transaction transaction = null;


        try {
            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();


            Article atc = session.get(Article.class, id);
            session.delete(atc);

            transaction.commit();
        }finally {
            if (session!= null){
                session.close();
            }
        }

    }


}
