package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n
 */
public class myPractice39 {
    public static void main(String[] args) {
        System.out.print("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if (n % 2 == 0)
            System.out.println("结果：" + even(n));
        else
            System.out.println("结果：" + odd(n));
    }

    //偶数
    private static double even(int n) {
        double sum = 0;
        for (int i = 2; i < n + 1; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    //奇数
    private static double odd(int n) {
        double sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

}
