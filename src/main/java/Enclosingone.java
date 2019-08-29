/**
 * Created by wangnan01 on 2017/4/5.
 */
public class Enclosingone {
    //非静态内部类
    public class InsideOne {}
    //静态内部类
    public static class InsideTwo{}
}

class Mytest02{
    public static void main(String args []){
        Enclosingone.InsideOne obj1 = new Enclosingone().new InsideOne();//非静态内部类对象
        Enclosingone.InsideTwo obj2 = new Enclosingone.InsideTwo();//静态内部类对象
        Enclosingone one = new Enclosingone();
    }
}
