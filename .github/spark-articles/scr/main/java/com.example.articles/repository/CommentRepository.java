import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CommentRepository {
    private final ConcurrentHashMap<CommentId, Comment> comments = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public CommentId generateId() {
        return new CommentId(idCounter.getAndIncrement());
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public void delete(CommentId id) {
        comments.remove(id);
    }
}
