package cc.heikafei.algorithm;

import java.util.Arrays;

/**
 * 归并算法
 * <p>
 * （1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * （2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * （3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * （4）重复步骤3直到某一指针达到序列尾
 * （5）将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //左边
            mergeSort(arr, low, mid);
            //右边
            mergeSort(arr, mid + 1, high);
            //左右归并
            merge(arr, low, mid, high);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;    //左指针
        int j = mid + 1;    //右指针
        int k = 0;
        //把较小的数先移到新数组中
        while (i <= mid && j < high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        //把新数组中的数覆盖nums数组
        for (int l = 0; l < temp.length; l++) {
            arr[l + low] = temp[l];
        }
    }

}
