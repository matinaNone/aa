import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by wangnan01 on 2016/10/9.
 */
public class HelloWorldFromWeb extends AbstractVerticle{
    //private Vertx vertx;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        //vertx = Vertx.vertx();
        Router router = Router.router(vertx);

        router.route("/web/*").handler(StaticHandler.create("web"));
        router.route("/api/*").handler(this::api);
        router.route("/api/*").handler(this::api2);

        vertx.createHttpServer().requestHandler(router::accept).listen(8081,(listen)->{
           if(listen.failed()){
               startFuture.fail(listen.cause());
           }else{
               startFuture.complete();
           }
        });
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        vertx.close((close)->{
            if(close.failed()){
                stopFuture.fail(close.cause());
            }else{
                stopFuture.complete();
            }
        });
    }

    public void api(RoutingContext context){
        JsonObject o = new JsonObject();
        o.put("id","1");
        o.put("name","wn223");
        context.put("aa", "aa");
        context.next();
//        context.response().end(Json.encodePrettily(o));
    }

    public void api2(RoutingContext context){
        context.put("aa", "bb");
        String b = context.get("aa");
        context.response().end(Json.encodePrettily(b));
    }

    public static void main(String[] args){
        Vertx.vertx().deployVerticle(HelloWorldFromWeb.class.getName());
    }
}
