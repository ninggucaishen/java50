package cc.test;

/**
 *题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * 程序分析：请抓住分子与分母的变化规律。
 */
public class myPractice20 {
    public static void main(String[] args) {
        double n1 = 1;
        double n2 = 1;
        double fraction = 0;
        double Sn = 0;
        for (int i = 0; i < 20; i++) {
            double t1 = n1;
            double t2 = n2;
            n1 = t1 + t2;
            n2 = t1;
            fraction = n1 / n2;
            Sn += fraction;
        }
        System.out.println("这个数列的前20项之和为：" + Sn);

    }
}
