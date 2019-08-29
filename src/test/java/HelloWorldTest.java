import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by wangnan01 on 2016/10/8.
 */
@RunWith(VertxUnitRunner.class)
public class HelloWorldTest {
    private Vertx vertx;
    @Before
    public void setup(TestContext context){
        vertx = Vertx.vertx();
        vertx.deployVerticle(HelloWorld.class.getName(),context.asyncAssertSuccess());

    }

    @Test
    public void test(TestContext context){
        Async async = context.async();
        HttpClient client = vertx.createHttpClient();
        client.get(8080,"localhost","/").handler((response)->{
            response.bodyHandler((body)->{
                context.assertTrue(body.toString().contains("Hello World!"));
                async.complete();
            });
        }).end();
    }

    @After
    public void tearDown(TestContext context){
        vertx.close(context.asyncAssertSuccess());
    }
}
