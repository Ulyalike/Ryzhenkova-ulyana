package com.example.articles.controller;

import com.example.articles.service.CommentService;
import com.example.articles.model.Comment;

import java.util.List;

public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<Comment> getCommentsByArticleId(Long articleId) {
        return commentService.getCommentsByArticleId(articleId);
    }

    public Comment createComment(Comment comment) {
        return commentService.createComment(comment);
    }

    public void deleteComment(Long id) {
        commentService.deleteComment(id);
    }
}
