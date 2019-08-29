import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by wangnan01 on 2017/11/9.
 */

public class Parse {
    @Test
    public void parse() {
        for (int i = 0; i < 1000; ++i) {
            int j = new Random().nextInt();
            Assert.assertEquals(Integer.toString(j), i2s(j));
        }
    }

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

}
