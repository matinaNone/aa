import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by wangnan01 on 2017/8/8.
 */
public class JingCaiTest {

    private static int getDigitalPartTicketCount(List<Map<Integer, Integer>> betIdCountList, List<Double> limitCountList) {//获取分区投注的彩票数量
        System.out.println("betIdCountList: " + betIdCountList);
        System.out.println("limitCountList: " + limitCountList);

        int ticketCount = 0;
        for (Map<Integer, Integer> betIdCountMap : betIdCountList) {
            long tc = 1;
            for (int partIndex : betIdCountMap.keySet()) {
                int c = (int) limitCountList.get(partIndex).longValue();
                tc *= getGroupCountNoSort(betIdCountMap.get(partIndex), c);
                System.out.println("tc: " + tc);
            }
            ticketCount += tc;
        }
        System.out.println("ticketCount: " + ticketCount);
        return ticketCount;
    }

    public static long getGroupCountNoSort(int n, int aGroupCount) {
        long result = mathFactorial(n) / (mathFactorial(n - aGroupCount) * mathFactorial(aGroupCount));
        return result;
    }

    public static long mathFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int get20Sel3StraightTicketCount(Map<Integer, List<Integer>> betIndexMap){
        List<Integer> numA = betIndexMap.get(0);
        List<Integer> numB = betIndexMap.get(1);
        List<Integer> numC = betIndexMap.get(2);
        int count = 0;
        for (int i : numA) {
            for (int j : numB) {
                j = j - 20;
                for (int k : numC) {
                    k = k - 40;
                    Set<Integer> tmp = new HashSet<>();
                    tmp.add(i);
                    tmp.add(j);
                    tmp.add(k);
                    if (tmp.size() != 3) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static String genCombineChoices(List<List<String>> resolvedNumbersList) {
        return LambdaUtils.join(
                resolvedNumbersList.stream().map(rn -> LambdaUtils.join(rn, ","))
                        .collect(toList()), "|");
    }

    private static String genDoubleRegionChoicesForSanGuo(List<List<String>> resolvedNumbersList) {
        return LambdaUtils.join(
                resolvedNumbersList.stream().map(JingCaiTest::genOneDoubleRegionChoicesForSanGuo).collect(toList()), "|");
    }

    private static String genOneDoubleRegionChoicesForSanGuo(List<String> resolvedNumbers) {
        String aPart = LambdaUtils.join(
                resolvedNumbers.stream().filter(s -> s.startsWith("a"))
                        .map(s -> s.substring(1)).collect(toList()), ",");
        String bPart = LambdaUtils.join(
                resolvedNumbers.stream().filter(s -> s.startsWith("b"))
                        .map(s -> s.substring(1)).collect(toList()), ",");
        String cPart = LambdaUtils.join(
                resolvedNumbers.stream().filter(s -> s.startsWith("c"))
                        .map(s -> s.substring(1)).collect(toList()), ",");
        String dPart = LambdaUtils.join(
                resolvedNumbers.stream().filter(s -> s.startsWith("d"))
                        .map(s -> s.substring(1)).collect(toList()), ",");
        System.out.println(cPart.equals(""));
        if(!"".equals(cPart) && !"".equals(dPart)){
            return aPart + "&" + bPart + "&" + cPart + "#" + dPart;
        }else{
            return aPart + "#" + bPart ;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map= new HashMap<>();
        map.put(0, 6);
        map.put(1, 1);
        List<Map<Integer, Integer>> betIdCountList = new ArrayList<>();
        betIdCountList.add(map);
        List<Double> limitCountList = new ArrayList<>();
        limitCountList.add(5.0);
        limitCountList.add(1.0);
//        getDigitalPartTicketCount(betIdCountList, limitCountList);

        Map<Integer, List<Integer>> betIndexMap = new HashMap<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(0);
        list0.add(1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(20);
        list1.add(21);
        List<Integer> list2 = new ArrayList<>();
        list2.add(40);
        list2.add(41);
        list2.add(42);
        List<Integer> list3 = new ArrayList<>();
        list3.add(60);
        betIndexMap.put(0, list0);
        betIndexMap.put(1, list1);
        betIndexMap.put(2, list2);
        betIndexMap.put(3, list3);
//        System.out.println(get20Sel3StraightTicketCount(betIndexMap));

        List<List<String>> resolveList = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("a01");
        a.add("a02");
        a.add("b03");
        a.add("c04");
        a.add("d01");
        resolveList.add(a);
//        System.out.println(genDoubleRegionChoicesForSanGuo(resolveList));

        IntStream.range(0, 10).forEach(i->{
            if(i == 2){
                System.out.println(i);
            }
        });

    }
}
