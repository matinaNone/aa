package DynamicProxy;

public class HelloWorld implements IHelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
