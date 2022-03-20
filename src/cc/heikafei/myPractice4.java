package cc.heikafei;

import java.util.Scanner;

/**
 * 题目：将一个大于2正整数分解质因数。例如：输入3, 3=3, 输入6, 6=2*3,输入90, 90=2*3*3*5。
 * <p>
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 */
public class myPractice4 {
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        deCompose(n);
    }

    private static void deCompose(int n) {
        System.out.print(n + "=");
        for (int i = 2; i < n + 1; i++) {
            while (n % i == 0 && n != i) {
                n /= i;
                System.out.print(i + "*");
            }
            if (n == i) {
                System.out.println(i);
                break;
            }
        }
    }
}
