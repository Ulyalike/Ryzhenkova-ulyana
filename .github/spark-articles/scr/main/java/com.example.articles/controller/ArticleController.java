import static spark.Spark.*;

public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        initRoutes();
    }

    private void initRoutes() {
        get("/api/articles", (req, res) -> articleService.getAll(), new JsonTransformer());
    }
}
