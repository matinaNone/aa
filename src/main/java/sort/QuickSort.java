package sort;

import java.util.Arrays;

/**
 * 网络版，随机取出一个基准值
 */
public class QuickSort {

    public static void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
        System.out.println(Arrays.toString(data));
    }

    private static int partition(int[] data, int start, int end) {
        int index = start + (int) (Math.random() * (end - start + 1)); //0~14
        System.out.println("index: " + index);
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int src[] = {8, 4, 5, 3, 9, 6, 1};
        quickSort_1(src, 0, src.length-1);
    }
}
