package cc.heikafei.algorithm;

import java.util.*;

/**
 * 猴子排序
 */
public class BogoSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 6, 2, 7, 3, 8, 9));
        System.out.println(list);
        Integer num = 0;
        Date startDate = new Date();
        while (!BogoSort.judgeSort(list)) {
            num++;
            Collections.shuffle(list);
            System.out.println(list);
        }
        System.out.println("共执行了" + num + "次，消耗时间" + (new Date().getTime() - startDate.getTime()) + "ms");
        System.out.println(list);
    }

    public static boolean judgeSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

