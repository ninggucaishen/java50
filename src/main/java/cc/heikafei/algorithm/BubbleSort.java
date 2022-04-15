package cc.heikafei.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, -7, 4, 9, -6, 8, 10, 4};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        //从第一个元素开始，向后依次成对比较，逆序则交换
        //对所有元素都进行这一操作
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮");
            for (int j : arr) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
