package Exercise;

/**
 * Created by wangnan01 on 2017/11/2.
 */
public class Table {
    static Bowl b1 = new Bowl(1);

    Table() {
        System.out.println("Table()");
        b2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl b2 = new Bowl(2);

    public static void main(String[] args) {

    }
}
