package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class myPractice24 {
    public static void main(String[] args) {
        System.out.print("请输入一个5位以内的正整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0 || n > 100000) {
            System.out.println("输入有误，请重输！");
        } else {
            System.out.println("这个数为" + getDigits(n) + "位数！");
            reversePrint(n);
        }
        sc.close();
    }

    private static int getDigits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 != 0)
                count++;
            n /= 10;
        }
        return count;
    }

    private static void reversePrint(int n) {
        System.out.print("逆序输出：");
        while (n > 0) {
            if (n % 10 != 0)
                System.out.print(n % 10);
            n /= 10;
        }
        System.out.println();
    }

}
