package Exercise;

/**
 * Created by wangnan01 on 2017/11/1.
 */
public class Bowl {

    static {
        System.out.println("Bowl static!");
    }

    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }

}
