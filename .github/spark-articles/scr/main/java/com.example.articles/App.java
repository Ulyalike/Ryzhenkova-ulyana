import static spark.Spark.*;

import com.google.gson.Gson;
import controllers.ArticleController;
import controllers.CommentController;
import utils.ExceptionHandler;

public class App {
    public static void main(String[] args) {
        port(4567);

        ExceptionHandler.registerHandlers();

        Gson gson = new Gson();
        ArticleController articleController = new ArticleController();
        CommentController commentController = new CommentController();

        path("/articles", () -> {
            get("", articleController::getAllArticles, gson::toJson);
            get("/:id", articleController::getArticleById, gson::toJson);
            post("", articleController::addArticle, gson::toJson);
            put("/:id", articleController::updateArticle, gson::toJson);
            delete("/:id", articleController::deleteArticle, gson::toJson);
        });

        path("/comments", () -> {
            post("", commentController::addComment, gson::toJson);
            delete("/:id", commentController::deleteComment, gson::toJson);
        });

        get("/articles-summary", articleController::getArticlesSummary);

        System.out.println("Server started on port 4567.");
    }
}
