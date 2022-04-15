package cc.heikafei.algorithm;

import java.util.Arrays;

/**
 * 插入排序算法
 *
 * 直接插入排序的基本操作是将一个记录插入到已经排好的有序表中，从而得到一个新的、记录数增1的有序表。
 * 对于给定的一组记录，初始时假定第一个记录自成一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，直到最后一个记录插到有序序列中为止
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {38, 65, 97, 76, 13, 27, 49, 27};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] a) {
        int j, insertNode;       //要插入的数据
        for (int k = 1; k < a.length; k++) {        //从数组的第二个元素开始循环将数组中的元素插入
            insertNode = a[k];      //设置数组中的第2个元素为第一次循环要插入的数据
            j = k - 1;
            while (j >= 0 && insertNode < a[j]) {
                a[j + 1] = a[j];        //如果要插入的元素小于第j个元素，就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNode;      //直到要插入的元素不小于第j个元素，将insertNode插入到数组中
        }
    }
}
