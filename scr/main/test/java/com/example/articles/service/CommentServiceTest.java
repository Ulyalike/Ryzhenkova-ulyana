import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class CommentServiceTest {

    private CommentService commentService;
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        commentRepository = new CommentRepository();
        commentService = new CommentService(commentRepository);
    }

    @Test
    public void testCreateComment() {
        Article article = new Article("Article Title", Set.of("tag1", "tag2"));
        Comment comment = commentService.createComment(article.getId(), "This is a comment");
        
        assertNotNull(comment);
        assertEquals("This is a comment", comment.getText());
        assertEquals(article.getId(), comment.getArticleId());
    }

    @Test
    public void testGetCommentsByArticleId() {
        Article article = new Article("Article Title", Set.of("tag1"));
        commentService.createComment(article.getId(), "First comment");
        commentService.createComment(article.getId(), "Second comment");
        
        var comments = commentService.getCommentsByArticleId(article.getId());
        assertEquals(2, comments.size());
    }

    @Test
    public void testDeleteComment() {
        Article article = new Article("Article Title", Set.of("tag1"));
        Comment comment = commentService.createComment(article.getId(), "Comment to delete");
        
        commentService.deleteComment(comment.getId());
        
        assertThrows(IllegalArgumentException.class, () -> commentService.getCommentById(comment.getId()));
    }
}
