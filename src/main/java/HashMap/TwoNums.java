package HashMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wangnan01 on 2019/8/22.
 */
public class TwoNums {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int minus = target - nums[i];
            if (hashMap.containsKey(minus)) {
                result = new int[]{hashMap.get(minus), i};
                return result;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] test = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            int temp = (target - nums[i]);

            if (test[temp] != 0) {
                return new int[]{test[temp]-1, i};
            }
            test[nums[i]] = i+1;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 7, 8};
//        System.out.println(Arrays.toString(twoSum(a, 9)));
//        twoSum(a, 9);

        System.out.println(Arrays.toString(twoSum2(a, 9)));
        System.out.println( 8 & 2047);
        System.out.println(Integer.toBinaryString(2048));

    }

}
