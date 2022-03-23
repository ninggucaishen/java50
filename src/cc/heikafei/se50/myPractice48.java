package cc.heikafei.se50;

/**
 * 题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
 * 每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。
 */
public class myPractice48 {
    public static void main(String[] args) {

        int n = 1234;
        int[] a = new int[4];

        //将n的数字逐个拆分依次存放进数组a中
        for (int i = 3; i >= 0; i--) {
            a[i] = n % 10;
            n /= 10;
        }

        //打印明文
        System.out.print("明文:");
        for (int i = 0; i < 4; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        //按照加密规则进行加密
        for (int i = 0; i < a.length; i++) {
            a[i] += 5;
            a[i] %= 10;
        }
        //第一位和第四位交换
        int temp = a[0];
        a[0] = a[3];
        a[3] = temp;
        //第二位和第三位交换
        int temp1 = a[2];
        a[2] = a[1];
        a[1] = temp1;

        //打印密文
        System.out.print("密文：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

}
