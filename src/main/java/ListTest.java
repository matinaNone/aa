import annotation.learn.SayHiAnnotation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Created by wangnan01 on 2017/3/15.
 */
public class ListTest {

    public static <T> String nTimes(T i, int times) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, times).forEach(ii -> sb.append(i));
        return sb.toString();
    }

    public static void main(String[] args) {
//        List<String> a = Collections.singletonList("a");
//        List<Integer> statusList = new ArrayList<>();
//        statusList.add(1);
//        statusList.add(2);
//        statusList.add(4);
//        statusList.add(5);
//        statusList.stream().filter(integer -> integer != 4);
//        System.out.println(statusList);


        List<Integer> a = range(3, 19).mapToObj(Integer::valueOf).collect(toList());
        a.sort((x, y) -> (x - y));
//        System.out.println(a);

        List<List<String>> QUICK_THREE_OPTIONS = new ArrayList<>();
        //空 0
        QUICK_THREE_OPTIONS.add(new ArrayList<>());
        //和值 1
        final List<String> sumOptions = range(3, 19).mapToObj(String::valueOf).collect(toList());
        QUICK_THREE_OPTIONS.add(sumOptions);
        //三同号 2
        final List<String> threeSameOptions = range(1, 7).mapToObj(i -> nTimes(i, 3)).collect(toList());
        threeSameOptions.add("3A");
        QUICK_THREE_OPTIONS.add(threeSameOptions);
        //二同号 3
        final List<String> twoSameOptions = range(1, 7).mapToObj(i -> nTimes(i, 2)).collect(toList());
        twoSameOptions.addAll(range(1, 7).mapToObj(String::valueOf).collect(toList()));
        twoSameOptions.addAll(range(1, 7).mapToObj(i -> nTimes(i, 2) + "*").collect(toList()));
        QUICK_THREE_OPTIONS.add(twoSameOptions);
        //三不同 4
        final List<String> threeDifferent = range(1, 7).mapToObj(String::valueOf).collect(toList());
        threeDifferent.add("3B");
        QUICK_THREE_OPTIONS.add(threeDifferent);
        //二不同 5
        final List<String> twoDifferent = range(1, 7).mapToObj(String::valueOf).collect(toList());
        QUICK_THREE_OPTIONS.add(twoDifferent);

//        System.out.println(QUICK_THREE_OPTIONS);

        List<List<String>> ELEVEN_C_FIVE_OPTIONS = new ArrayList<>();

        //组合选项
        ELEVEN_C_FIVE_OPTIONS.add(IntStream.range(1, 12).mapToObj(i -> String.format("%02d", i)).collect(toList()));
        //前二直选
        final List<String> frontTwoDirect = new ArrayList<>();
        frontTwoDirect.addAll(IntStream.range(1, 12).mapToObj(i -> "a" + String.format("%02d", i)).collect(toList()));
        frontTwoDirect.addAll(IntStream.range(1, 12).mapToObj(i -> "b" + String.format("%02d", i)).collect(toList()));
        ELEVEN_C_FIVE_OPTIONS.add(frontTwoDirect);
        //前三直选
        final List<String> frontThreeDirect = new ArrayList<>();
        frontThreeDirect.addAll(IntStream.range(1, 12).mapToObj(i -> "a" + String.format("%02d", i)).collect(toList()));
        frontThreeDirect.addAll(IntStream.range(1, 12).mapToObj(i -> "b" + String.format("%02d", i)).collect(toList()));
        frontThreeDirect.addAll(IntStream.range(1, 12).mapToObj(i -> "c" + String.format("%02d", i)).collect(toList()));
        ELEVEN_C_FIVE_OPTIONS.add(frontThreeDirect);

        final int TWENTY_C_FIVE_SAN_GUO_SHI_LI = 1;
        final int TWENTY_C_FIVE_SAN_GUO_FIVE = 2;
        final int TWENTY_C_FIVE_SAN_GUO_EIGHT = 3;
        final int TWENTY_C_FIVE_SAN_GUO_FRONT_THREE_DIRECT = 4;
        final List<List<String>> TWENTY_C_FIVE_SAN_GUO_OPTIONS = new ArrayList<>();

        //势力选择
        TWENTY_C_FIVE_SAN_GUO_OPTIONS.add(IntStream.range(1, 4).mapToObj(i -> String.format("%02d", i)).collect(toList()));
        //组合选项
        final List<String> group = new ArrayList<>();
        group.addAll(IntStream.range(1, 21).mapToObj(i -> "a" + String.format("%02d", i)).collect(toList()));
        group.addAll(IntStream.range(1, 4).mapToObj(i -> "b" + String.format("%02d", i)).collect(toList()));
        TWENTY_C_FIVE_SAN_GUO_OPTIONS.add(group);
        //前三直选
        final List<String> frontThreeDirect1 = new ArrayList<>();
        frontThreeDirect1.addAll(IntStream.range(1, 21).mapToObj(i -> "a" + String.format("%02d", i)).collect(toList()));
        frontThreeDirect1.addAll(IntStream.range(1, 21).mapToObj(i -> "b" + String.format("%02d", i)).collect(toList()));
        frontThreeDirect1.addAll(IntStream.range(1, 21).mapToObj(i -> "c" + String.format("%02d", i)).collect(toList()));
        frontThreeDirect1.addAll(IntStream.range(1, 4).mapToObj(i -> "d" + String.format("%02d", i)).collect(toList()));
        TWENTY_C_FIVE_SAN_GUO_OPTIONS.add(frontThreeDirect1);

//        System.out.println(ELEVEN_C_FIVE_OPTIONS);

        List<String> s = new ArrayList<>();
        s.add("3");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("9");
//        s.add("11");
//        System.out.println(c);
        List<List<String>> s1 = new ArrayList<>();
        s1.add(s);
        List<String> targetNumbers = s1.stream().map(l -> join(l, ",")).collect(toList());

//        System.out.println(getPermutationXSrcLists(s, 2, true));

        long tl = computeElevenCFiveGroup(targetNumbers.get(0));
//        System.out.println(tl);
        System.out.println(TWENTY_C_FIVE_SAN_GUO_OPTIONS);

    }

    private static List<List<String>> getPermutationXSrcLists(List<String> resolvedNumbers, int x, boolean lStrip) {
        int a = 97;
        return IntStream.range(a, a + x).mapToObj(i ->
                resolvedNumbers.stream()
                        .filter(n -> n.startsWith(String.valueOf((char) i)))
                        .map(n -> lStrip ? n.substring(1) : n).collect(toList())
        ).collect(toList());
    }

    private static long computeElevenCFiveGroup(String targetNumber) {
        List<Integer> i = Arrays.stream(targetNumber.split(",")).map(Integer::parseInt).collect(toList());
        long res = 0;
        for (int ie : i) {
            res += (1L << (ie - 1));
        }
        return res;
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
}
