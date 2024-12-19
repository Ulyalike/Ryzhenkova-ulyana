package com.example.articles;

import com.example.articles.config.AppConfig;
import com.example.articles.controller.ArticleController;
import com.example.articles.controller.CommentController;
import com.example.articles.model.Article;
import com.example.articles.model.Comment;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ArticleController articleController = AppConfig.articleController();
        CommentController commentController = AppConfig.commentController();

        Article article = articleController.createArticle("Sample Article", "This is a sample article.");
        System.out.println("Created Article: " + article);

        Comment comment = commentController.addComment(article.getId(), "This is a comment.");
        System.out.println("Added Comment: " + comment);

        List<Article> articles = articleController.getAllArticles();
        System.out.println("All Articles: " + articles);

        List<Comment> comments = commentController.getCommentsByArticleId(article.getId());
        System.out.println("Comments for Article ID " + article.getId() + ": " + comments);

        commentController.deleteComment(comment.getId());
        System.out.println("Deleted Comment ID: " + comment.getId());
    }
}
