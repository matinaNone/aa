/**
 * Created by wangnan01 on 2017/8/30.
 */
public class BreakTest {
    public static void main(String[] args) {
        for(int i = 0; i< 10; i++){
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ":"+ j);
                if(j == 5){
                    System.out.println(i + ": 5");
                    break;
                }
            }
        }
    }
}
