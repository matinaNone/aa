package suanfa;

import java.util.Arrays;

/**
 * Created by wangnan01 on 2019/8/27.
 */
public class NumReverse {



    //int转char数组，数组内交换值，char数组转String字符串，字符串转整形数字
    static int reverse1(int num) {
        boolean isNegative = false;

        if (num < 0){
            if(num == Integer.MIN_VALUE){
                return 0;
            }
            num = -num;
            isNegative = true;
        }

        String s = String.valueOf(num);
        char[] cArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cArray[i] = s.charAt(i);
        }

        int length = cArray.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = cArray[i];
            cArray[i] = cArray[length - i - 1];
            cArray[length - i - 1] = temp;

        }

        String sRes = new String(cArray);

        long numLong = Long.parseLong(sRes);
        if (numLong > Integer.MAX_VALUE || numLong < Integer.MIN_VALUE){
            return 0;
        }
        int numRes = Integer.parseInt(sRes);
        if (isNegative){
            numRes = -numRes;
        }
        return numRes;
    }


    static int reverse2(int num) {
        boolean isNegative = false;
        if (num < 0){
            if(num == Integer.MIN_VALUE){
                return 0;
            }
            num = -num;
            isNegative = true;
        }

        String s = String.valueOf(num);
        int res;
        long resLong = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = Integer.parseInt(Character.toString(s.charAt(i)));
            resLong += cur * Math.pow(10, i);
            if(resLong > Integer.MAX_VALUE){
                return 0;
            }
        }
        res = Integer.parseInt(String.valueOf(resLong));
        if(isNegative){
            res = -res;
        }
        return res;
    }

    public static int reverse3(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


    public static void main(String[] args) {

//        int i = 1534236469;
        int i = 123;

        System.out.println(reverse3(i));
    }


}
