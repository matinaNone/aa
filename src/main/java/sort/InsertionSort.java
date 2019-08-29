package sort;

import java.util.Arrays;

/**
 * Created by wangnan01 on 2017/9/19.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] x = {3, 2, 6, 4, 7, 1, 9, 8};
        insertion_sort(x);
        int[] a = {1, 2, 5, 7, 2, 3, 4, 6};
//        mergeArray(a, 0, 3, 7);
    }

    //{3, 2, 6, 4, 7, 1, 9, 8}
    //插入排序之交换：从前往后，后面的比前面的小则交换
    public static void insertion(int[] params) {
        for (int i = 1; i < params.length; i++) {
            for (int j = 0; j < i; j++) {
                if (params[i] < params[j]) {
                    int temp = params[i];
                    params[i] = params[j];
                    params[j] = temp;
                    System.out.println(i + "-" + j + ":");
                    System.out.println(Arrays.toString(params));
                }
            }
        }
    }


    //{3, 2, 6, 4, 7, 1, 9, 8}
    //插入排序之移位：类似于打扑克时，每起一张牌，往手中已有有序牌中插入
    // 从后往前，先比较base和前一位大小，如果base比前一位大则此趟不用比较了；base比前一位小，才接着比较前面几位，比较后移位
    static void insertion_sort(int[] data) {
//        for (int i = 1; i < data.length; i++) {
//            if (data[i - 1] > data[i]) {
//                int temp = data[i];
//                int j = i;
//                while (j > 0 && data[j - 1] > temp) {
//                    data[j] = data[j - 1];
//                    j--;
//                }
//                data[j] = temp;
//                System.out.println("第" +
//                        i + "趟： " + Arrays.toString(data));
//            }
//        }

        //{3, 2, 6, 4, 7, 1, 9, 8} 23647198
        for (int i = 1; i < data.length; i++) {
            int key = data[i]; //待插入元素
            int j = i - 1; //已排好序的末位
            if (key > data[j]) continue; //如果待插入元素比已排好序末位元素大，则不用移位，继续下一个
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];//后移
                j--;
            }
            data[j + 1] = key; //将待插入元素放到移位后的空位上
            System.out.println("第" +
                    i + "趟： " + Arrays.toString(data));
        }
    }

    //选择排序：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    index = j; //遍历出未排序的序列中最小的元素下标
                }
            }
            //交换当前趟的下标和最小值下标
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
            System.out.println("第" +
                    i + "趟： " + Arrays.toString(a));
        }

    }

    public static void mergeArray(int[] a, int p, int q, int r) { //p=0, q=3, r=7
        int n1 = q - p + 1; //3-0+1 = 4
        int n2 = r - q; //7-3 = 4
        int[] left = new int[n1 + 1]; //5
        int[] right = new int[n2 + 1]; //5
        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[q + j + 1];
        }
        left[n1] = 100000000;
        right[n2] = 100000000;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i = i + 1;
            } else {
                a[k] = right[j];
                j = j + 1;
            }
        }
        System.out.println(Arrays.toString(a));
    }


}
