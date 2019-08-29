package DynamicProxy;

public class Test2 {
    public static void main(String[] args) {
        IHelloWorld hw = new HelloWorld();
        HelloWorldProxy proxy = new HelloWorldProxy((HelloWorld) hw);
        proxy.sayHello();
    }
}
