package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 * 程序分析：利用while语句,条件为输入的字符不为'\n'.
 */
public class myPractice7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();     //将一行字符转化为字符串
        sc.close();
        count(str);
    }

    private static void count(String str) {
        String E1 = "[\\u4e00-\\u9fa5]";
        String E2 = "[a-zA-Z]";
        String E3 = "[0-9]";
        String E4 = "\\s";
        int countChinese = 0;
        int countEnglish = 0;
        int countNumber = 0;
        int countSpace = 0;
        int countOther = 0;
        char[] arrayChar = str.toCharArray();   //将字符串转为字符处理
        String[] arrayString = new String[arrayChar.length];    //汉字只能作为字符串来处理
        for (int i = 0; i < arrayChar.length; i++) {
            arrayString[i] = String.valueOf(arrayChar[i]);      //遍历字符串数组中的元素
        }
    }
}
