package JVM;

/**
 * Created by wangnan01 on 2017/11/20.
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(ConstClass.HELLOWORLD);
//        System.out.println(SubClass.value);
        SuperClass[] sc = new SuperClass[10];
    }
}
