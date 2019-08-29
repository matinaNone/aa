package sort;

import java.util.Arrays;

public class BubbleSort {


    //和插入排序之交换类似，但冒泡是元素和相邻的交换，插入是外层和内层元素交换
    public static void bubble(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                System.out.println("第" + (i+1) +"趟，第" + (j+1) + "次排序：");
                if (arrays[j + 1] < arrays[j]) {

                    int temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
                for (int k = 0;k<arrays.length; k++){
                    System.out.print(arrays[k]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {43,45,23,56,3};
        bubble(ints);
    }
}
