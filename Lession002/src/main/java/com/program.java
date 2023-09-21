package com;

import com.entity.Article;
import com.repository.ArticleRepository;

import java.util.List;

public class program {
    public static void main(String[] args) {
        System.out.println("Buoi 1 JavaAdvance");

        ArticleRepository articleRepository = new ArticleRepository();

//        Article article = new Article("JavaAdvance", "Backend", Article.Status.OPEN);
//        articleRepository.createArticle(article);

//       Article article2 = new Article("NodeJS", "Backend", Article.Status.OPEN);
//       articleRepository.createArticle(article2);

//       List<Article> articles= articleRepository.getListArticles();
//        for (Article article: articles){
//            System.out.println(article);
//        }
//
//       // articleRepository.updateArticle(1,"Python");
//        articleRepository.deleteArticle(2);

        Article article3 = articleRepository.getListArticlesByTitle("JavaAdvance");
        System.out.println(article3);

    }
}
