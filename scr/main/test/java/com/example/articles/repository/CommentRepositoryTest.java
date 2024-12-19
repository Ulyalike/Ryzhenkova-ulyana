import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        commentRepository = new CommentRepository(); 
    }

    @Test
    public void testCreateComment() {
        Comment comment = new Comment("Test Comment", 1L);  
        Comment savedComment = commentRepository.create(comment);
        
        assertNotNull(savedComment);
        assertEquals("Test Comment", savedComment.getText());
    }

    @Test
    public void testFindCommentById() {
        Comment comment = new Comment("Test Comment", 1L);
        Comment savedComment = commentRepository.create(comment);
        
        Comment foundComment = commentRepository.findById(savedComment.getId());
        
        assertNotNull(foundComment);
        assertEquals(savedComment.getId(), foundComment.getId());
        assertEquals("Test Comment", foundComment.getText());
    }

    @Test
    public void testDeleteComment() {
        Comment comment = new Comment("Test Comment", 1L);
        Comment savedComment = commentRepository.create(comment);
        
        commentRepository.delete(savedComment.getId());
        
        Comment deletedComment = commentRepository.findById(savedComment.getId());
        
        assertNull(deletedComment);
    }

    @Test
    public void testFindAllComments() {
        Comment comment1 = new Comment("Comment 1", 1L);
        Comment comment2 = new Comment("Comment 2", 1L);
        commentRepository.create(comment1);
        commentRepository.create(comment2);
        
        List<Comment> comments = commentRepository.findAll();
        
        assertNotNull(comments);
        assertEquals(2, comments.size());
    }
}
