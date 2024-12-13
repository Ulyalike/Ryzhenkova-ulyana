import spark.Request;
import spark.Response;

public class ExceptionHandler {

    public static void handleIllegalArgument(Exception exception, Request request, Response response) {
        response.status(400); 
        response.body("{\"error\":\"" + exception.getMessage() + "\"}");
        response.type("application/json");
    }

    public static void handleUnexpectedException(Exception exception, Request request, Response response) {
        response.status(500); 
        response.body("{\"error\":\"Internal server error\"}");
        response.type("application/json");
        System.err.println("Unexpected error: " + exception.getMessage());
        exception.printStackTrace();
    }

    public static void registerHandlers() {
        spark.Spark.exception(IllegalArgumentException.class, ExceptionHandler::handleIllegalArgument);
        spark.Spark.exception(Exception.class, ExceptionHandler::handleUnexpectedException);
    }
}
