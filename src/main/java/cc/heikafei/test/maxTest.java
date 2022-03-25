package cc.heikafei.test;

import java.util.Scanner;

/**
 * 利用Java中的Math类工具包实现三个数的大小比较
 */
public class maxTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入a：");
        int a = sc.nextInt();

        System.out.print("请输入b：");
        int b = sc.nextInt();

        System.out.print("请输入c：");
        int c = sc.nextInt();

        sc.close();

        int max1 = Math.max(a, b);
        int max2 = Math.max(max1, c);

        System.out.println("a,b,c三个数中最大值为：" + max2);
    }
}
