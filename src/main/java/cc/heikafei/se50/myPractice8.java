package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 * 程序分析：关键是计算出每一项的值。
 */
public class myPractice8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("求s=a+aa+aaa+aaaa+aa...a的值，请输入a的值：");
        try {
            int a = sc.nextInt();
            if (a > 9 || a < 1) {
                System.out.println("请输入0-10之间的数！");
                return;
            }
            System.out.println("求s=a+aa+aaa+aaaa+aa...a的值，请输入a组合的最大长度：");
            int b = sc.nextInt();
            if (b < 1) {
                System.out.println("请输入正数！");
                return;
            }
            sc.close();
            System.out.println(expressed(a, b) + add(a, b));
        } catch (Exception e) {
            System.out.println("输入参数异常！");
            sc.close();
        }
    }

    //求和表达式
    private static String expressed(int a, int b) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (int i = 1; i < b + 1; i++) {
            s2 = s2.append(a);
            s1 = s1.append(b);
            if (i < b) {
                s1 = s1.append("+");
            }
        }
        s2.append("=");
        return s2.toString();
    }

    //求和
    private static long add(int a, int b) {
        long sum = 0;
        long subSum = a;
        for (int i = 1; i < b + 1; i++) {
            sum += subSum;
            subSum = subSum * 10 + a;
        }
        return sum;
    }

}
