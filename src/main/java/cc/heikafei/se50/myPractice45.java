package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 题目：判断一个数能被几个9整除
 */
public class myPractice45 {
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        sc.close();
        int count = 0;
        while (l > 8) {
            l /= 9;
            count++;
        }
        System.out.println(l + "能被" + count + "个9整除！");
    }

}
