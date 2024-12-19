package com.example.articles.model;

public class Comment {
    private CommentId id;
    private ArticleId articleId;
    private String text;

    public Comment(CommentId id, ArticleId articleId, String text) {
        this.id = id;
        this.articleId = articleId;
        this.text = text;
    }

    public CommentId getId() {
        return id;
    }

    public ArticleId getArticleId() {
        return articleId;
    }

    public String getText() {
        return text;
    }
}
