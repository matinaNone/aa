package Exercise;

/**
 * Created by wangnan01 on 2017/11/2.
 */
public class TestValue {
    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }

    public static void main(String argv[]) {
        TestValue t = new TestValue();
        t.first();
    }
}
