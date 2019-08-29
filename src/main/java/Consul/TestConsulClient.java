package Consul;

import com.orbitz.consul.*;
import com.orbitz.consul.async.ConsulResponseCallback;
import com.orbitz.consul.cache.KVCache;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import com.orbitz.consul.model.health.ServiceHealth;
import com.orbitz.consul.model.kv.Value;
import com.orbitz.consul.option.QueryOptions;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class TestConsulClient {
    public static Consul client = Consul.builder().build();
    public static AgentClient agentClient = client.agentClient();
    public static Logger logger;

    public static void registerService(String serviceId, String name, int port, long ttl, Iterable<String> tags, Map<String, ? extends String> metadata) {
        Registration service = ImmutableRegistration.builder()
                .id(serviceId)
                .name(name)
                .port(port)
                .check(Registration.RegCheck.ttl(ttl)) // registers with a TTL of 3 seconds
                .tags(tags)
                .meta(metadata)
                .build();

        agentClient.register(service);

        // Check in with Consul (serviceId required only).
        // Client will prepend "service:" for service level checks.
        // Note that you need to continually check in before the TTL expires, otherwise your service's state will be marked as "critical".
        try {
            agentClient.pass(serviceId);
        } catch (NotRegisteredException e) {
            e.printStackTrace();
        }
    }

    public static List<ServiceHealth> getHealthNodes(String service){
        HealthClient healthClient = client.healthClient();
        List<ServiceHealth> nodes = healthClient.getHealthyServiceInstances(service).getResponse();
        return nodes;
    }

    public static String storeKV(String key, String value){
        KeyValueClient kvClient = client.keyValueClient();
        kvClient.putValue(key, value);
        return kvClient.getValueAsString(key).get();
    }

    public static void valueChangeListener(String rootPath){
        final KeyValueClient kvClient = client.keyValueClient();
        KVCache cache = KVCache.newCache(kvClient, rootPath);

        cache.addListener(newValues -> {
            System.out.println(".........." + cache.getListeners());
            System.out.println("changed====================");

            Optional<Value> newValue = newValues.values().stream()
                    .filter(value -> value.getKey().equals(rootPath))
                    .findAny();

            newValue.ifPresent(value -> {
                Optional<String> decodedValue = newValue.get().getValueAsString();
                decodedValue.ifPresent(v -> System.out.println(String.format("Value is: %s", v))); //prints "bar"
            });
        });
        cache.start();
        cache.stop();
    }





    public static void main(String[] args) {

        //注册服务
        registerService("1", "myService", 8080, 10L,
                Collections.singletonList("tag1"),
                Collections.singletonMap("version", "1.0"));

        //获取可用节点
        List<ServiceHealth> nodes = getHealthNodes("myService");
//        System.out.println(Arrays.toString(nodes.toArray()));

        //存储键值对
        String value = storeKV("foo1","bar");
//        System.out.println(value);

        //监听KV变化
//
//        int i = 500;
//        while (i>0){
//            valueChangeListener("foo");
//            i--;
//        }

//        watch("foo");
        final KeyValueClient kvClient = client.keyValueClient();
        ConsulResponseCallback<Optional<Value>> callback = new ConsulResponseCallback<Optional<Value>>() {
            AtomicReference<BigInteger> index = new AtomicReference<BigInteger>(null);

            @Override
            public void onComplete(ConsulResponse<Optional<Value>> consulResponse) {

                if (consulResponse.getResponse().isPresent()) {
                    Value v = consulResponse.getResponse().get();
                    System.out.println("Value has been fetched for sampleKey = " + v.getValue());
                    logger.info("Value is: {}", v.getValue());
                }

                index.set(consulResponse.getIndex());
                watch();
            }

            void watch(){
                String s = kvClient.getValueAsString("foo").get();
                System.out.println("watch s: "+s);
            }
            @Override
            public void onFailure(Throwable throwable) {

                System.out.println("Value was not fetched for sampleKey");

                logger.info("Error encountered", throwable);
                watch();
            }
        };

        kvClient.getValue("foo", QueryOptions.blockMinutes(10, new BigInteger("0")).build(), callback);
    }
}
