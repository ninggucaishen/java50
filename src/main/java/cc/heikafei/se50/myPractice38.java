package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
 */
public class myPractice38 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        char[] ch = str.toCharArray();
        System.out.println(str + "共" + (ch.length) + "个字符");
    }
}
