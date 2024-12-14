package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false) 
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") 
    private String content;

    @Column(name = "comments_count", nullable = false) 
    private int commentsCount = 0;

    @Column(nullable = false) 
    private boolean trending = false;

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content, int commentsCount, boolean trending) {
        this.title = title;
        this.content = content;
        this.commentsCount = commentsCount;
        this.trending = trending;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public boolean isTrending() {
        return trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }

    public void updateTrendingStatus() {
        this.trending = this.commentsCount > 3;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentsCount=" + commentsCount +
                ", trending=" + trending +
                '}';
    }
}
