package cc.heikafei;

import java.util.Scanner;

/**
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。
 * 程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，然后再用x与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。
 */
public class myPractice15 {
    /**
     * 方法一：采用传统的比较法
     * @param args
     */
    /*public static void main(String[] args) {
        System.out.println("请输入三个数：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        sc.close();
        System.out.println("排序结果为：" + sort(x, y, z));
    }

    private static String sort(int x, int y, int z) {
        String s = null;
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (x > z) {
            int temp = x;
            x = z;
            z = temp;
        }
        if (y > z) {
            int temp = y;
            y = z;
            z = temp;
        }
        s = x + " " + y + " " + z;
        return s;
    }*/

    /**
     * 方法二：采用Java中的Math类
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入x:");
        int x = sc.nextInt();

        System.out.println("请输入y:");
        int y = sc.nextInt();

        System.out.println("请输入z:");
        int z = sc.nextInt();

        sc.close();

        int min1 = Math.min(x, y);
        int min2 = Math.min(min1, z);

        System.out.println("最小值为：" + min2);
    }
}
