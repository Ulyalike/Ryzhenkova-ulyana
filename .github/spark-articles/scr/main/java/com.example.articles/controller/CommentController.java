import static spark.Spark.*;

import com.google.gson.Gson;

public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;
    private final Gson gson;

    public CommentController(CommentService commentService, ArticleService articleService) {
        this.commentService = commentService;
        this.articleService = articleService;
        this.gson = new Gson();
        setupRoutes();
    }

    private void setupRoutes() {

        post("/articles/:articleId/comments", (req, res) -> {
            String articleIdParam = req.params("articleId");
            ArticleId articleId = new ArticleId(Long.parseLong(articleIdParam));
            String text = gson.fromJson(req.body(), CommentRequest.class).getText();

            Comment comment = commentService.addCommentToArticle(articleId, text);
            res.status(201);
            return gson.toJson(comment);
        });

        delete("/comments/:commentId", (req, res) -> {
            String commentIdParam = req.params("commentId");
            CommentId commentId = new CommentId(Long.parseLong(commentIdParam));

            commentService.deleteComment(commentId);
            res.status(204); 
            return "";
        });

        get("/articles/:articleId/comments", (req, res) -> {
            String articleIdParam = req.params("articleId");
            ArticleId articleId = new ArticleId(Long.parseLong(articleIdParam));

            Article article = articleService.getArticleById(articleId);
            return gson.toJson(article.comments());
        });
    }

    private static class CommentRequest {
        private String text;

        public String getText() {
            return text;
        }
    }
}
