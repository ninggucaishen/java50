package cc.heikafei;

import java.util.Scanner;

/**
 * 题目：输入某年某月某日，判断这一天是这一年的第几天？
 * 程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。
 */
public class myPractice14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\D");
        System.out.println("请输入当前日期（年-月-日）：");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int date = sc.nextInt();
        sc.close();
        System.out.println("今天是" + year + "年的第" + analysis(year, month, date) + "天");
    }

    private static int analysis(int year, int month, int date) {
        int n = 0;
        int[] month_date = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        if ((year % 400) == 0 || ((year % 4) == 0) && ((year % 100) != 0)) {
            month_date[2] = 28;
        }
        for (int i = 0; i < month; i++) {
            n += month_date[i];
        }
        return n + date;
    }
}
