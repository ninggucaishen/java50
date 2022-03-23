package cc.heikafei.se50;

/**
 * 题目：利用递归方法求5!。
 * 程序分析：递归公式：fn=fn_1*4!
 */
public class myPractice23 {
    public static void main(String[] args) {
        System.out.println("5的阶乘为：" + fact(5));
    }

    private static long fact(int i) {
        if (i == 1)
            return 1;
        else
            return fact(i - 1) * i;
    }

}
