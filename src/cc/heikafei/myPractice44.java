package cc.heikafei;

import java.util.Scanner;

/**
 * 题目：一个偶数总能表示为两个素数之和。
 */
public class myPractice44 {
    public static void main(String[] args) {
        System.out.println("请输入一个偶数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n % 2 != 0) {
            System.out.println("你输入的不是偶数！请重输！");
            return;
        }
        toPrime(n);
    }

    //偶数分解为素数之和
    private static void toPrime(int n) {
        for (int i = 2; i < n / 2 + 1; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println(n + "=" + (i) + "+" + (n - i));
            }
        }
    }

    //判断是否为素数
    private static boolean isPrime(int m) {
        boolean flag = true;
        for (int i = 2; i < Math.sqrt(m) + 1; i++) {
            if (m % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
