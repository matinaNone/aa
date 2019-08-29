package jiami.learn;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by wangnan01 on 2017/11/18.
 */
public class Base64 {
    public static byte[] decryptBASE64(String s) throws IOException {
        return new BASE64Decoder().decodeBuffer(s);
    }

    public static String encryptBASE64(byte[] b){
        return new BASE64Encoder().encodeBuffer(b);
    }

    public static void main(String[] args) {
        String s = "wangnan";
        byte[] b = s.getBytes();
        System.out.println(b);
        System.out.println(encryptBASE64(b));
    }
}
