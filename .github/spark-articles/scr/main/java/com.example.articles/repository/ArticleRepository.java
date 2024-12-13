import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ArticleRepository {
    private final ConcurrentHashMap<ArticleId, Article> articles = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ArticleId generateId() {
        return new ArticleId(idCounter.getAndIncrement());
    }

    public void save(Article article) {
        articles.put(article.id(), article);
    }

    public Article findById(ArticleId id) {
        return articles.get(id);
    }

    public void delete(ArticleId id) {
        articles.remove(id);
    }

    public Collection<Article> findAll() {
        return articles.values();
    }
}
