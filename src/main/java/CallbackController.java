import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class CallbackController {
    public static boolean pub ;
    public static JsonObject json = new JsonObject();
    public CallbackController(){
    }
    public static Object handleMpesa(Request req, Response res){

        return doMpesa(req, res);
    }
    private static Object doMpesa(Request req, Response res){

        System.out.println("Here is the confirmation:  " + req.body());
        if(req.body() != null) {
            pub = true;
        }

        Mpesa received = new Gson().fromJson(req.body(),Mpesa.class);

        System.out.println("Here is the status "+received.getStatus());

        return received;
    }

}
