import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class ArticleServiceTest {

    private ArticleService articleService;
    private ArticleRepository articleRepository;
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        articleRepository = new ArticleRepository();
        commentRepository = new CommentRepository();
        articleService = new ArticleService(articleRepository, commentRepository);
    }

    @Test
    public void testCreateArticle() {
        Article article = articleService.createArticle("Test Article", Set.of("tag1", "tag2"));
        assertNotNull(article);
        assertEquals("Test Article", article.getTitle());
        assertEquals(2, article.getTags().size());
    }

    @Test
    public void testGetAllArticles() {
        articleService.createArticle("Article 1", Set.of("tag1"));
        articleService.createArticle("Article 2", Set.of("tag2"));
        
        var articles = articleService.getAll();
        assertEquals(2, articles.size());
    }

    @Test
    public void testGetArticleById() {
        Article article = articleService.createArticle("Test Article", Set.of("tag1"));
        Article fetchedArticle = articleService.getArticleById(article.getId());
        
        assertNotNull(fetchedArticle);
        assertEquals(article.getId(), fetchedArticle.getId());
    }

    @Test
    public void testUpdateArticle() {
        Article article = articleService.createArticle("Old Title", Set.of("tag1"));
        Article updatedArticle = articleService.updateArticle(article.getId(), "New Title", Set.of("tag2"));
        
        assertNotNull(updatedArticle);
        assertEquals("New Title", updatedArticle.getTitle());
    }

    @Test
    public void testDeleteArticle() {
        Article article = articleService.createArticle("Test Article", Set.of("tag1"));
        articleService.deleteArticle(article.getId());
        
        assertThrows(IllegalArgumentException.class, () -> articleService.getArticleById(article.getId()));
    }
}
