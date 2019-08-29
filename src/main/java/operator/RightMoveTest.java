package operator;

import java.util.LinkedList;

/**
 * Created by wangnan01 on 2017/12/25.
 */
public class RightMoveTest {
    public static void main(String[] args) {
        int i = 4;
        System.out.println(Integer.toBinaryString(i));
        i = i >>> 1;
        System.out.println(Integer.toBinaryString(i));
        i += i;
        System.out.println(i);


    }
}
