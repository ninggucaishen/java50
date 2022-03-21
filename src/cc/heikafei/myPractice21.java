package cc.heikafei;

/**
 * 题目：求1+2!+3!+...+20!的和
 * 程序分析：此程序只是把累加变成了累乘。
 */
public class myPractice21 {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += factorial(i + 1);
        }
        System.out.println("该阶乘前20项之和为：" + sum);
    }

    private static long factorial(int n) {
        int mult = 1;
        for (int i = 1; i < n + 1; i++) {
            mult *= i;

        }
        return mult;
    }

}
