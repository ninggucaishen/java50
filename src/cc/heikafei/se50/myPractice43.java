package cc.heikafei.se50;

/**
 * 题目：求0—7所能组成的奇数个数。（0不能为首位，末位是1,3,5,7，每个数字只能用1次）
 */
public class myPractice43 {
    public static void main(String[] args) {
        int count = 0;
        //声明由数字组成的数
        int n = 8;
        //一位数
        count = n / 2;
        //两位数
        count += (n - 1) * n / 2;
        //三位数
        count += (n - 1) * n * n / 2;
        //四位数
        count += (n - 1) * n * n * n / 2;
        //五位数
        count += (n - 1) * n * n * n * n / 2;
        //六位数
        count += (n - 1) * n * n * n * n * n / 2;
        //七位数
        count += (n - 1) * n * n * n * n * n * n / 2;
        System.out.println("0-7所能组成的奇数个数为：" + count);
    }
}
