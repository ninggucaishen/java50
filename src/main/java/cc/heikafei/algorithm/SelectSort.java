package cc.heikafei.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 选择排序(Selection-sort) 是一种简单直观的排序算法。
 * 工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 6, 3, 9, 2, 1, 5, 7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        //先遍历所有元素
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //记录最小元素的下标
                    min = j;
                }
            }
            //如果最小元素和当前遍历数的下标不一致，说明下标为min的数比当前遍历的数更小
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
