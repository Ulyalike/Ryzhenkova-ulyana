import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class AppTest {

    private static final Gson gson = new Gson();

    @BeforeAll
    public static void setup() {
        App.main(new String[]{});
        Spark.awaitInitialization();
    }

    @AfterAll
    public static void tearDown() {
        Spark.stop();
    }

    @Test
    public void testE2EFlow() {
        String articleTitle = "Test Article";
        HttpResponse<JsonNode> createArticleResponse = Unirest.post("http://localhost:4567/articles")
                .header("Content-Type", "application/json")
                .body("{\"title\":\"" + articleTitle + "\",\"tags\":[\"tag1\",\"tag2\"]}")
                .asJson();
        assertEquals(200, createArticleResponse.getStatus());
        long articleId = createArticleResponse.getBody().getObject().getLong("id");

        String commentText = "Test Comment";
        HttpResponse<JsonNode> addCommentResponse = Unirest.post("http://localhost:4567/comments")
                .header("Content-Type", "application/json")
                .body("{\"articleId\":" + articleId + ",\"text\":\"" + commentText + "\"}")
                .asJson();
        assertEquals(200, addCommentResponse.getStatus());
        long commentId = addCommentResponse.getBody().getObject().getLong("id");

        String updatedArticleTitle = "Updated Test Article";
        HttpResponse<JsonNode> updateArticleResponse = Unirest.put("http://localhost:4567/articles/" + articleId)
                .header("Content-Type", "application/json")
                .body("{\"title\":\"" + updatedArticleTitle + "\",\"tags\":[\"tag3\"]}")
                .asJson();
        assertEquals(200, updateArticleResponse.getStatus());

        HttpResponse<JsonNode> deleteCommentResponse = Unirest.delete("http://localhost:4567/comments/" + commentId)
                .asJson();
        assertEquals(200, deleteCommentResponse.getStatus());

        HttpResponse<JsonNode> getArticleResponse = Unirest.get("http://localhost:4567/articles/" + articleId)
                .asJson();
        assertEquals(200, getArticleResponse.getStatus());
        String returnedTitle = getArticleResponse.getBody().getObject().getString("title");
        assertEquals(updatedArticleTitle, returnedTitle);
        assertTrue(getArticleResponse.getBody().getObject().getJSONArray("comments").isEmpty());
    }
}
