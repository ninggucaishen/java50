package cc.heikafei.test;

import java.util.Locale;
import java.util.StringJoiner;

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

        //字符串拼接
        String str4 = "";
        for (int i = 0; i < 10; i++) {
            str4 = str4 + "," + i;
        }
        System.out.println(str4);       //,0,1,2,3,4,5,6,7,8,9

        //字符串拼接二
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 10; i++) {
            sb.append(',');
            sb.append(i);
        }
        System.out.println(sb);     //,0,1,2,3,4,5,6,7,8,9

        //字符串拼接三
        String[] names = {"Alice", "Bob", "Jane"};
        StringJoiner sj = new StringJoiner(",", "hello,", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj);     //hello,Alice,Bob,Jane!

        //字符串拼接四
        String join = String.join(", ", names);
        System.out.println(join);       //Alice, Bob, Jane

    }
}
