import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleRepositoryTest {

    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() {
        articleRepository = new ArticleRepository(); 
    }

    @Test
    public void testCreateArticle() {
        Article article = new Article("Test Article", List.of("tag1", "tag2"));
        Article savedArticle = articleRepository.create(article);
        
        assertNotNull(savedArticle);
        assertEquals("Test Article", savedArticle.getTitle());
        assertTrue(savedArticle.getTags().contains("tag1"));
    }

    @Test
    public void testFindArticleById() {
        Article article = new Article("Test Article", List.of("tag1", "tag2"));
        Article savedArticle = articleRepository.create(article);
        
        Article foundArticle = articleRepository.findById(savedArticle.getId());
        
        assertNotNull(foundArticle);
        assertEquals(savedArticle.getId(), foundArticle.getId());
        assertEquals("Test Article", foundArticle.getTitle());
    }

    @Test
    public void testDeleteArticle() {
        Article article = new Article("Test Article", List.of("tag1", "tag2"));
        Article savedArticle = articleRepository.create(article);
        
        articleRepository.delete(savedArticle.getId());
        
        Article deletedArticle = articleRepository.findById(savedArticle.getId());
        
        assertNull(deletedArticle);
    }

    @Test
    public void testGetAllArticles() {
        Article article1 = new Article("Article 1", List.of("tag1"));
        Article article2 = new Article("Article 2", List.of("tag2"));
        articleRepository.create(article1);
        articleRepository.create(article2);
        
        List<Article> articles = articleRepository.findAll();
        
        assertNotNull(articles);
        assertEquals(2, articles.size());
    }
}
