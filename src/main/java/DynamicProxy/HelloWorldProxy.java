package DynamicProxy;

public class HelloWorldProxy implements IHelloWorld {
    HelloWorld helloWorld;

    public HelloWorldProxy(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public void sayHello() {
        System.out.println("start~~~~~");
        helloWorld.sayHello();
        System.out.println("end~~~~");
    }
}
