import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by wangnan01 on 2017/12/20.
 */
public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "(";
        System.out.println(URLEncoder.encode(s, "utf-8"));
//        System.out.println(URLDecoder.decode(s, "utf-8"));
    }
}
