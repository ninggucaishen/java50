package cc.heikafei;

import java.util.Scanner;

/**
 * 题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
 */
public class myPractice47 {
    public static void main(String[] args) {
        System.out.println("请输入7个整数(1-50)：");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();
        int n5 = sc.nextInt();
        int n6 = sc.nextInt();
        int n7 = sc.nextInt();
        sc.close();
        System.out.println("开始打印*：");
        printStar(n1);
        printStar(n2);
        printStar(n3);
        printStar(n4);
        printStar(n5);
        printStar(n6);
        printStar(n7);
    }

    private static void printStar(int m) {
        System.out.print(m + "个*：");
        for (int i = 0; i < m; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
