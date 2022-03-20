package cc.heikafei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：企业发放的奖金根据利润提成。
 * 利润(I)低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，
 * 低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
 * 20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，
 * 高于100万元时，超过100万元的部分按1%提成，
 * 从键盘输入当月利润I，求应发放奖金总数？
 * <p>
 * 程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。
 */
public class myPractice12 {
    public static void main(String[] args) {
        System.out.println("请输入当前利润：");
        long profit = Long.parseLong(keyInput());
        System.out.println("应发奖金：" + bonus(profit));
    }

    //接收从键盘输入的内容
    private static String keyInput() {
        String str = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = bufferedReader.readLine();
        } catch (Exception e) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    //计算奖金
    private static Long bonus(long profit) {
        //奖金
        long prize = 0;
        //毛利润
        long profitSub = profit;
        if (profitSub > 1000000) {
            //纯利润
            profit = profitSub - 1000000;
            prize += profit * 0.01;
        }
        if (profitSub > 600000 && profitSub < 1000000) {
            profit = profitSub - 600000;
            prize += profit * 0.015;
        }
        if (profitSub > 400000 && profitSub < 600000) {
            profit = profitSub - 400000;
            prize += profit * 0.03;
        }
        if (profitSub > 200000 && profitSub < 400000) {
            profit = profitSub - 200000;
            prize += profit * 0.05;
        }
        if (profitSub > 100000 && profitSub < 200000) {
            profit = profitSub - 100000;
            prize += profit * 0.075;
        }
        if (profitSub > 0 && profitSub < 100000) {
            prize += profitSub * 0.1;
        }
        return prize;
    }
}
