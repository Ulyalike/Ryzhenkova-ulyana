import java.util.List;
import java.util.Set;

public record Article(ArticleId id, String title, Set<String> tags, List<Comment> comments) {}
