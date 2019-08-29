package sort;

import java.util.Arrays;

public class Bubble2 {
    public static void sort(int[] src) {
        int length = src.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i -1; j++) {
                if (src[j] > src[j+1]) {
                    int temp = src[j+1];
                    src[j+1] = src[j];
                    src[j] = temp;
                }
                System.out.println("第" + i + "趟，第" + j + "次： " + Arrays.toString(src));
            }
            System.out.println("第" + i + "趟结束： " + Arrays.toString(src));
            System.out.println("==================================");
        }
    }

    public static void main(String[] args) {
        int[] src = {8, 4, 6, 3, 7, 9, 5};
        sort(src);
    }
}
