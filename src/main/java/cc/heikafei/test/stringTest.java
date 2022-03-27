package cc.heikafei.test;

import java.util.Locale;

/**
 * 字符串测试
 */
public class stringTest {
    public static void main(String[] args) {
        String str1 = "hello";
        System.out.println(str1);       //hello

        //字符串比较
        String str2 = "hello";
        System.out.println(str1 == str2);       //true
        System.out.println(str1.equals(str2));      //true

        //字符串比较二
        String str3 = "HELLO".toLowerCase();
        System.out.println(str1 == str3);       //false
        System.out.println(str1.equals(str3));      //true

        //将字符串全部转为大写
        str1 = str1.toUpperCase();
        System.out.println(str1);       //HELLO

        //是否有子串
        System.out.println(str1.contains("he"));        //false
        System.out.println(str1.contains("HE"));        //true

        //提取子串
        System.out.println(str1.substring(2, 4));       //LL
        System.out.println(str1.substring(2));      //LLO

        //去除字符串首位空白字符
        System.out.println(" \thello,ning\r\n".trim());

    }
}
