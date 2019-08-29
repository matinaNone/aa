import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by wangnan01 on 2017/5/10.
 */
public class TestVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Router router = Router.router(vertx);
        router.route("/api/*").handler(this::api);

        vertx.createHttpServer().requestHandler(router::accept).listen(8081, (listen) -> {
            if (listen.failed()) {
                startFuture.fail(listen.cause());
            } else {
                startFuture.complete();
            }
        });
    }

    private void api(RoutingContext routingContext) {
        String price = config().getString("freeShipPrice");
        routingContext.response().end(Json.encodePrettily(price));
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(TestVerticle.class.getName());
    }
}
