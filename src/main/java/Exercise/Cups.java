package Exercise;

/**
 * Created by wangnan01 on 2017/11/2.
 */
public class Cups {
    Cup cup1;
    Cup cup2;
    {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups(){
        System.out.println("Cups");
    }

    Cups(int i){
        System.out.println("Cups int " + i);
    }

    public static void main(String[] args) {
        new Cups();
        new Cups(2);
    }

}
