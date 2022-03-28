package cc.heikafei.myPractice;

/**
 * 斐波那契数列
 * TODO：JUnit测试使用
 */
public class Factorial {
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
