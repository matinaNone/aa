package suanfa;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wangnan01 on 2019/8/23.
 */
public class SubSum {
    static HashMap<Integer, ArrayList<Integer>> sum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> subAll = new HashMap<>();
        int sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> subArray = new ArrayList<>();
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = temp + nums[j];
                subArray.add(nums[j]);
                ArrayList<Integer> subArray2 = new ArrayList<>(subArray);
                subAll.put(temp, subArray2);
                if (temp > sumMax) {
                    sumMax = temp;
                }
            }
        }
        result.put(sumMax, subAll.get(sumMax));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1,   -3, 4,   -1, 2,   1,   -5, 4};
//        System.out.println(sum(nums));
        System.out.println(maxSumRec(nums, 0, 8));
    }


    private static int maxSubSum3(int[] a) {
        int res = a[0];
        int sum = 0;
        for (int num: a) {
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    static int sumMax(int[] nums){

        int sumMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > sumMax) {
                    sumMax = temp;
                }
            }
        }
        return sumMax;

    }


    private static int maxSubSum4(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

   static int maxSumRec(int data[], int left, int right) {
        if (right - left == 1) {
            //如果当前序列只有一个元素
            return data[left];
        }
        int center = (left + right) / 2;//计算当前序列的分裂点
        int maxLeftSum = maxSumRec(data, left, center);
        int maxRightSum = maxSumRec(data, center, right);
        //计算左边界最大子序列和
        int leftBonderSum = 0;
        int maxLeftBonderSum = data[center - 1];
        for (int i = center - 1; i >= left; i--) {
            leftBonderSum += data[i];
            if (maxLeftBonderSum < leftBonderSum) {
                maxLeftBonderSum = leftBonderSum;
            }
        }
        //计算右边界最大子序列和
        int rightBonderSum = 0;
        int maxRightBonderSum = data[center];
        for (int i = center; i < right; i++) {
            rightBonderSum += data[i];
            if (maxRightBonderSum < rightBonderSum) {
                maxRightBonderSum = rightBonderSum;
            }
        }
        //返回当前序列最大子序列和
        return getMaxNum(maxLeftBonderSum + maxRightBonderSum, maxLeftSum, maxRightSum);
    }

    static int getMaxNum(int a,int b,int c){
        if (a > b&&a > c){
            return a;
        }
        if (b > a&&b > c){
            return b;
        }
        return c;
    }

}
