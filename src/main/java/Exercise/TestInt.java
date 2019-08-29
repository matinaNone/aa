package Exercise;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by wangnan01 on 2017/11/21.
 */
public class TestInt {
    public static void main(String[] args) {
//        int m, n;
//        for(m=0,n=-1; Boolean.getBoolean(String.valueOf(n=1)); m++,n++){
//            n++;
//            System.out.println("n++");
//        }
//        System.out.println("nop");
        int[] a = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < a.length/2; i++) {
            int temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        HashMap<Integer,Integer> h = new HashMap<>();
    }
}
