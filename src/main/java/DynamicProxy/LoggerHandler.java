package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerHandler implements InvocationHandler {
    private Object target;

    public LoggerHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Logger.start();
        Object result = method.invoke(target, args);
        Logger.end();
        return result;
    }
}
