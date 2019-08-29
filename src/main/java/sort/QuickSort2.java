package sort;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * wangnan版，每次取最后一个元素作为基准值
 */
public class QuickSort2 {
    public static void quickSort(int[] A, int start, int end) {
        if (end > A.length - 1) {
            return;
        }
        if (start == end) return;
        int boundary = partion(A, start, end);
        System.out.println(boundary);

        if (boundary > start) { //0, 2
            quickSort(A, start, boundary-1);

        }
        if (boundary < end) {
            quickSort(A, boundary+1, end);
        }
    }

    public static int partion(int[] A, int start, int end) {
        int base = A[end];
        int cursor = start - 1;
        for (int i = start; i < end; i++) {
            if (A[i] <= base) {
                cursor++;
                swap(A, cursor, i);
            }
        }
        swap(A, cursor + 1, end);
        System.out.println("start: " + start + "  end: " + end + "=======" + Arrays.toString(A));
        return cursor + 1;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int A[] = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(A, 0, 7);
//        System.out.println(Arrays.toString(A));
    }

}
