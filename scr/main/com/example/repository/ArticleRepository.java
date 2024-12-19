package com.example.articles.repository;

import com.example.articles.model.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAll();
    Article findById(Long id);
    Article save(Article article);
    void deleteById(Long id);
}
