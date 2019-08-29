import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Created by wangnan01 on 2016/10/8.
 */
public class HelloWorld extends AbstractVerticle{
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpServer().requestHandler((request)->{
            request.response().putHeader("content-type","text/html").end("<h1>Hello World!</h1>");
        }).listen(8080,(listen)->{
            startFuture.complete();
        });

        Context context = vertx.getOrCreateContext();

//        JsonObject jsonObject = new JsonObject().put("id", 1).put("name", "wn");
//        User j = jsonObject.mapTo(User.class);

        User j =  new User(new JsonObject().put("id", 1).put("name", "wn"));
        System.out.println(j.getId());
        System.out.println(j.getName());
    }

    public static void main(String[] args){
        Vertx.vertx().deployVerticle(HelloWorld.class.getName());
    }
}
