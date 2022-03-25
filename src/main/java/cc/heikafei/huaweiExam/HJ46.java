package cc.heikafei.huaweiExam;

import java.util.Scanner;

/**
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 */
public class HJ46 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            System.out.print("请输入一个整数k：");
            int k = sc.nextInt();
            System.out.println(str.substring(0, k));
        }
    }
}
