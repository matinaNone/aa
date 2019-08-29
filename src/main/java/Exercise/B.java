package Exercise;

/**
 * Created by wangnan01 on 2017/11/1.
 */
public class B {
    static B t1 = new B();

    public B() {
        System.out.println("构造函数");
    }

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    void f1() {
        System.out.println("aa");
    }

    public static void main(String[] args) {
//        B t = new B();
    }
}



