import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by wangnan01 on 2017/8/28.
 */
public class TicketLongTest {
    //抢地盘
    private static long computeTwentyCFiveShiLiGroup(String targetNumber) {
        List<Integer> i = Arrays.stream(targetNumber.split(",")).map(Integer::parseInt).collect(toList());
        long res = 0;
        for (int ie : i) {
            res += (1L << (ie - 1));
        }
        return res;
    }

    //任五/任八
    private static long computeDoubleRegionForSanGuo(String targetNumber) {
        String[] rb = targetNumber.split("#");
        List<Integer> r = Arrays.stream(rb[0].split(",")).map(Integer::parseInt).collect(toList());
        List<Integer> b = Arrays.stream(rb[1].split(",")).map(Integer::parseInt).collect(toList());
        long res = 0;
        for (int re : r) {
            res += (1L << (3 + re - 1));
        }
        res += (1L << (b.get(0) - 1));
        return res;
    }

    //冠亚军
    private static long computeDoubleRegionForSanGuoDirectThree(String targetNumber) {
        String[] rb = targetNumber.split("#");
        List<Integer> r = Arrays.stream(rb[0].split("&")).map(Integer::parseInt).collect(toList());
        List<Integer> b = Arrays.stream(rb[1].split(",")).map(Integer::parseInt).collect(toList());
        long res = 0;
        res += (1L << (3 + 20 + 20 + r.get(0) -1));
        res += (1L << (3 + 20 + r.get(1) -1));
        res += (1L << (3 + r.get(2) -1));
        res += (1L << (b.get(0) - 1));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(computeTwentyCFiveShiLiGroup("01,02"));
        System.out.println(computeDoubleRegionForSanGuo("01,02,03,04,05#01"));
        System.out.println(computeDoubleRegionForSanGuoDirectThree("01&02&03#01"));

    }

}
