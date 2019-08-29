package lambda.learn;

/**
 * Created by wangnan01 on 2017/6/15.
 *
 */
public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    public void sayHello() {
        class EnglishGreeting implements HelloWorld {
            String name = "world1";
            public EnglishGreeting(){

            }
            @Override
            public void greet() {
                greetSomeone("world2");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("hello " + name);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();


        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "frenchGreeting1";

            @Override
            public void greet() {
                greetSomeone("frenchGreeting2");
        }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("hello " + name);
            }

        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "spanishGreeting1";
            @Override
            public void greet() {
                greetSomeone("spanishGreeting2");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("hello " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("abby");
        spanishGreeting.greet();
    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses c = new HelloWorldAnonymousClasses();
        c.sayHello();
    }
}

