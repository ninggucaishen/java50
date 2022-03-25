package cc.heikafei.se50;

import static java.lang.Math.pow;

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 * <p>
 * 程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class myPractice3 {
    public static void main(String[] args) {

        System.out.println("水仙花数如下：");
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;    //百位
            int b = i % 100 / 10;   //十位
            int c = i % 100 - b * 10;   //个位
            if (i == pow(a, 3) + pow(b, 3) + pow(c, 3)) {
                System.out.println(i);
            }
        }
    }

}
