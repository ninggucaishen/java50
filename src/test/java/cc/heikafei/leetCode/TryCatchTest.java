package cc.heikafei.leetCode;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TryCatchTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/3 21:14
 * @Version 1.0
 */
public class TryCatchTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {

        try {
            double aa = 10 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("’’æ…÷¥––");
        }
    }
}
