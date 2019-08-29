package Exercise;

/**
 * Created by wangnan01 on 2017/11/9.
 */
public class IntParseString {
    public static String i2s(int i) {
        StringBuilder s = new StringBuilder();
        boolean m = false;
        if (i < 0) {
            m = true;
            i = -i;
        }

        do {
            s.append((char) (i % 10 + 48));
        } while ((i /= 10) != 0);

        if (s.length() == 0) {
            s.append(0);
        } else {
            if (m) {
                s.append('-');
            }
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(i2s(100));
        System.out.println((byte)'1');

    }
}
