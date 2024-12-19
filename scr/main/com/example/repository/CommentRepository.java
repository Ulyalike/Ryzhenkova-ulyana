package com.example.articles.repository;

import com.example.articles.model.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> findByArticleId(Long articleId);
    Comment save(Comment comment);
    void deleteById(Long id);
}
