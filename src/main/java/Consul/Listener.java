package Consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.async.ConsulResponseCallback;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.kv.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Listener implements ConsulResponseCallback {

    @Override
    public void onComplete(ConsulResponse consulResponse) {

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
