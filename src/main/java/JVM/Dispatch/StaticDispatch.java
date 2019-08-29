package JVM.Dispatch;

public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy){
        System.out.println("Hello, guy!");
    }

    public void sayHello(Man guy){
        System.out.println("Hello, gentleman!");
    }

    public void sayHello(Woman guy){
        System.out.println("Hello, Lady!");
    }

    public static void main(String[] args) {
        StaticDispatch staticDispatch = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();

        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);

        staticDispatch.sayHello(new Man());
        staticDispatch.sayHello(new Woman());


    }
}
