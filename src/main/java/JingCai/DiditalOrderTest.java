package JingCai;

import com.google.gson.Gson;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangnan01 on 2017/9/8.
 */
public class DiditalOrderTest extends AbstractVerticle {
    private static Gson gson = new Gson();

    @Override
    public void start() throws Exception {

        ProxyOptions proxyOptions = new ProxyOptions();
        proxyOptions.setHost("127.0.0.1");
        proxyOptions.setPort(8888);
        proxyOptions.setType(ProxyType.HTTP);

        WebClientOptions webClientOptions = new WebClientOptions();
//        webClientOptions.setProxyOptions(proxyOptions);

        WebClient client = WebClient.create(vertx, webClientOptions);

        List<String> betId = Arrays.asList("0","1","3","5","7","8","9","10");
        List<List<String>> betIdList = new ArrayList<>();
        betIdList.add(betId);
        CreateOrderParamsModel createOrderParamsModel = new CreateOrderParamsModel(504, "1000",
                2017090751, 1,0, "889,5;",1,1,betIdList, 0, 0);
        String caipiaos = gson.toJson(createOrderParamsModel);

        CreateOrderSubmitParams params = new CreateOrderSubmitParams(caipiaos);

        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.set("caipiaos", "AAAeyJvVHlwZSI6NTEzLCJzaW5nbGUiOiI1MDAiLCJwZXJpb2QiOjE3MDgxNzA0NywibXVsdGlwbGUiOjEsImdvbGQiOjEwMDAsInVzZU9iamVjdCI6IiIsInBsYXlUeXBlIjoyLCJjb250aW51b3VzVGltZXMiOjEsImJldFBsYXlUeXBlSWRzIjpbWyIwIiwiMSIsIjIiLCIzIiwiNCIsIjIxIl1dLCJzdG9wRm9sbG93IjowLCJzdWJtaXRTb3VyY2UiOjB9");
//        form.set("usertoken", 106083178);

        JsonObject jsonObject = new JsonObject();
        jsonObject.put("caipiaos","AAAeyJvVHlwZSI6NTEzLCJzaW5nbGUiOiI1MDAiLCJwZXJpb2QiOjE3MDgxNzA0NywibXVsdGlwbGUiOjEsImdvbGQiOjEwMDAsInVzZU9iamVjdCI6IiIsInBsYXlUeXBlIjoyLCJjb250aW51b3VzVGltZXMiOjEsImJldFBsYXlUeXBlSWRzIjpbWyIwIiwiMSIsIjIiLCIzIiwiNCIsIjIxIl1dLCJzdG9wRm9sbG93IjowLCJzdWJtaXRTb3VyY2UiOjB9");
        jsonObject.put("usertoken",106083178);





        client.post(8080, "192.168.16.153", "/JingCaiServer/simple/digital/create_order.do") // simple/digital/create_order.do
                .putHeader("content-type","application/json; charset=UTF-8")
                .setQueryParam("usertoken","106083178")
                .setQueryParam("caipiaos", "AAAeyJvVHlwZSI6NTEzLCJzaW5nbGUiOiI1MDAiLCJwZXJpb2QiOjE3MDgxNzA0NywibXVsdGlwbGUiOjEsImdvbGQiOjEwMDAsInVzZU9iamVjdCI6IiIsInBsYXlUeXBlIjoyLCJjb250aW51b3VzVGltZXMiOjEsImJldFBsYXlUeXBlSWRzIjpbWyIwIiwiMSIsIjIiLCIzIiwiNCIsIjIxIl1dLCJzdG9wRm9sbG93IjowLCJzdWJtaXRTb3VyY2UiOjB9")
//                .sendForm(form, ar -> {
                 .send( ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Buffer> response = ar.result();
                        System.out.println("Got HTTP response with status " + response.statusCode());
                        System.out.println("result: " + response.bodyAsString());
                    } else {
                        System.out.println(ar.cause().getMessage());
                        ar.cause().printStackTrace();
                    }
                });


    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        Runner.runExample(DiditalOrderTest.class);
    }
}
