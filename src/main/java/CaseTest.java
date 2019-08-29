/**
 * Created by wangnan01 on 2017/7/14.
 */
public class CaseTest {

    static void print(int i){
        switch (i){
            case 0:
            case 1:
                System.out.println(1);
                break;
            case 2:
            case 3:
                System.out.println(2);
                break;
        }

    }

    public static void main(String[] args) {
        print(2);
    }
}
