import java.util.*;

public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public Article createArticle(String title, Set<String> tags) {
        ArticleId id = articleRepository.generateId();
        Article article = new Article(id, title, tags, new ArrayList<>());
        articleRepository.save(article);
        return article;
    }

    public List<Article> getAll() {
        return new ArrayList<>(articleRepository.findAll());
    }

    public Article getArticleById(ArticleId id) {
        Article article = articleRepository.findById(id);
        if (article == null) {
            throw new IllegalArgumentException("Article not found for id: " + id.id());
        }
        return article;
    }

    public Article updateArticle(ArticleId id, String newTitle, Set<String> newTags) {
        Article existingArticle = getArticleById(id);
        Article updatedArticle = new Article(
            id, 
            newTitle, 
            newTags, 
            existingArticle.comments()
        );
        articleRepository.save(updatedArticle);
        return updatedArticle;
    }

    public void deleteArticle(ArticleId id) {
        Article article = getArticleById(id);
        articleRepository.delete(id);
    }

    public Comment addCommentToArticle(ArticleId articleId, String text) {
        Article article = getArticleById(articleId);
        CommentId commentId = commentRepository.generateId();
        Comment comment = new Comment(commentId, articleId, text);

        List<Comment> updatedComments = new ArrayList<>(article.comments());
        updatedComments.add(comment);

        Article updatedArticle = new Article(article.id(), article.title(), article.tags(), updatedComments);
        articleRepository.save(updatedArticle);
        commentRepository.save(comment);
        return comment;
    }

    public void deleteComment(CommentId commentId) {
        Comment comment = commentRepository.findById(commentId);
        if (comment == null) {
            throw new IllegalArgumentException("Comment not found for id: " + commentId.id());
        }

        Article article = getArticleById(comment.articleId());
        List<Comment> updatedComments = article.comments().stream()
            .filter(c -> !c.id().equals(commentId))
            .toList();

        Article updatedArticle = new Article(article.id(), article.title(), article.tags(), updatedComments);
        articleRepository.save(updatedArticle);
        commentRepository.delete(commentId);
    }
}
