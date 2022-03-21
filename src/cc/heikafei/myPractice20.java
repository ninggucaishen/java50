package cc.heikafei;

/**
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * 程序分析：请抓住分子与分母的变化规律
 */
public class myPractice20 {
    public static void main(String[] args) {
        double m = 1;
        double n = 1;
        double fraction;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            double t1 = m;
            double t2 = n;
            m = t1+t2;
            n = t1;
            fraction = m/n;
            sum += fraction;
        }
        System.out.println("这个数列的前20项之和为：" + sum);
    }
}
