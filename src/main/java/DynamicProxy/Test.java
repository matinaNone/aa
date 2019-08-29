package DynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        IHelloWorld hw = new HelloWorld();
        LoggerHandler handler = new LoggerHandler(hw);
        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(
                            Thread.currentThread().getContextClassLoader(),
                            hw.getClass().getInterfaces(), handler);
        proxy.sayHello();



    }
}
