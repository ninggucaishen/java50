package cc.heikafei.se50;

/**
 * 题目：一个数如果恰好等于它的所有因子之和，这个数就称为"完数"。
 * 例如6=1＋2＋3.编程找出1000以内的所有完数。
 */
public class myPractice9 {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("以下是1000以内的完数：");
        for (int i = 1; i <= 1000; i++) {
            checkIs(i);
        }
        System.out.println("1000以内共有" + count + "个！");
    }

    //判断是否为完数
    private static void checkIs(int i) {
        int sum = 0;
        //用1~i-1去整除i，如果能被整除，则j即为i的因子，加到sum中去
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                sum += j;
            }
        }
        //如果i所有因子相加后的sum和i本身的值相同，则i为完数，并计数加一
        if (sum == i) {
            count++;
            System.out.println(i);
        }
    }

}
