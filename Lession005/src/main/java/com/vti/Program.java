package com.vti;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("BrSE2210 Buoi1 Java Advance");

//        DemoSingleton demoSingleton1 = new DemoSingleton();
//        DemoSingleton demoSingleton2 = new DemoSingleton();
       // A.showInfo();

//        A a = new A();
//
//        a.showInfo();
        /* Demo singleton */
//        DemoSingleton demoSingleton = DemoSingleton.getInstance();
//        DemoSingleton.getInstance();

        ArticleRepository articleRepository = new ArticleRepository();


//        Article article = new Article("Java Advance", "Backend", Article.Status.OPEN);
//        articleRepository.createArticle(article);

//        Article article2 = new Article("NodeJs", "Backend", Article.Status.OPEN);
//        articleRepository.createArticle(article2);

//        List<Article> articles =  articleRepository.getListArticles();
//        for (Article article : articles) {
//            System.out.println(article);
//        }

        articleRepository.updateArticle("b9697eeb-96a7-46b9-ac99-20db531f68ce", "Python");

        //articleRepository.deleteArticle(2);
//        Article article3 = articleRepository.getListArticleByTitle("Java Advance");
//        System.out.println(article3);

    }
}
