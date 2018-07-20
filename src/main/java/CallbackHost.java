import static spark.Spark.*;
import spark.Session;

public class CallbackHost {
    String status;
    CallbackController callbackController = new CallbackController();
    public CallbackHost(){
        int maxThreads = 80;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads,minThreads,timeOutMillis);

        staticFiles.location("/public");

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET,POST,PUT,UPDATE,DELETE,OPTIONS");
            response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.type("application/json");
        });

        //ROUTES
        //handle home route
        post("/confirmation","application/json", (req, res) -> {

            return callbackController.handleMpesa(req, res);
        });
        //catch ALL
        get("*", "application/json", (req, res)-> { return "This request is not supported. \n"; });

    }

  /*  public static void main(String[] args) {
        new CallbackHost();
    }*/
}