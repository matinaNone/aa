package Exercise;

/**
 * Created by wangnan01 on 2017/12/1.
 */
public class BreakTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if(i == 3){
//                System.out.println(i);
//                continue;
                break;
            }
            System.out.println(i);
        }
    }
}
