import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by xiongjy on 2015/12/30.
 */
public class LambdaUtils {
    public static <T> String nTimes(T i, int times) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, times).forEach(ii -> sb.append(i));
        return sb.toString();
    }

    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    public static <T> String join(Collection<T> c, String separator) {
        if (c == null || c.size() == 0) {
            return "";
        }
        StringBuilder sb = null;
        for (T e : c) {
            if (sb == null) {
                sb = new StringBuilder().append(e);
            } else {
                sb.append(separator).append(e);
            }
        }
        return sb == null ? "" : sb.toString();
    }

    public static String join(Collection<String> c, String separator, String placeholder, char start, int cnt) {
        StringBuilder sb = null;
        if (c == null || c.size() == 0) {
            sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(separator).append(placeholder);
            }
        } else {
            for (char i = start; i < start + cnt; i++) {
                boolean has = false;
                for (String e : c) {
                    if (e.startsWith(String.valueOf(i))) {
                        has = true;
                        if (sb == null) {
                            sb = new StringBuilder().append(e.substring(1));
                        } else {
                            sb.append(separator).append(e.substring(1));
                        }
                        break;
                    }
                }
                if (!has && sb != null) {
                    sb.append(separator).append(placeholder);
                }
            }
        }
        return sb == null ? "" : sb.toString();
    }

    public static <T> List<T> singleElementList(T element) {
        List<T> res = new ArrayList<>();
        res.add(element);
        return res;
    }
}
