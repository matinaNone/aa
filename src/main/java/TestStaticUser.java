/**
 * Created by wangnan01 on 2017/5/11.
 */
public class TestStaticUser extends TestStatic {
    private static final long serialVersionUID = 1L;
    public final double i = Math.random();// 每次得到的结果不一样
    private final static int finalID;
    private static int finalID2;
    private int finalID3;

    static  {
        System.out.println("派生类 Static 静态语句块");
        finalID=1000;
    }

    {
        System.out.println("派生类  非静态语句块");
        finalID2+=1;
        finalID3+=1;
    }

    /** full constructor */
    public TestStaticUser() {
        System.out.println("派生类  默认无参构造器");

    }
    public static void IintTest() {
        System.out.println("派生类 Static Iint");
    }

    public static void main(String[] args) {
        TestStatic.Iint();
        TestStaticUser.Iint();
//        System.out.println(TestStaticUser.finalID);
//        TestStatic ueser = new TestStaticUser();
    }
}
