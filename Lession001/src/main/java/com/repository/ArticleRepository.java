package com.repository;


import com.utils.HibernateUtils;

public class ArticleRepository {
    private HibernateUtils hibernateUtils;

    public ArticleRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
}
