package sort;

import java.util.Arrays;

public class HeapSort {

    // Todo
    public static void printTree(int[] A){
        int f = (int) Math.sqrt(A.length) + 1;
        for (int i = 0; i < f; i++) {
            int parent = A[i/2];
            int left = A[2*i +1];
            int right = A[2*i +2];
            System.out.println("第" +
                     i+
                    "层，父节点：" + parent +
                    " 左节点：" + left +
                    " 右节点：" + right);
        }
    }

    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
            System.out.println( i + "构造堆：" + Arrays.toString(list));
        }

        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
            System.out.println( i + "排序： " + Arrays.toString(list));
        }
    }

    private static void headAdjust(int[] list, int len, int i) {

        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;

    }

    public static void main(String[] args) {
        int[] A = {3, 7, 2, 5, 4};
        headSort(A);
        System.out.println(Arrays.toString(A));
    }
}
