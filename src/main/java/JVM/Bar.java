package JVM;

/**
 * Created by wangnan01 on 2017/11/6.
 */
public class Bar {
    int a = 1;
    static int b = 2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        System.out.println( new Bar().sum(3));
    }
}
