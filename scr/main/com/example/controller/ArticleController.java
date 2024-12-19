package com.example.articles.controller;

import com.example.articles.service.ArticleService;
import com.example.articles.model.Article;

import java.util.List;

public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    public Article getArticleById(Long id) {
        return articleService.getArticleById(id);
    }

    public Article createArticle(Article article) {
        return articleService.createArticle(article);
    }

    public void deleteArticle(Long id) {
        articleService.deleteArticle(id);
    }
}
