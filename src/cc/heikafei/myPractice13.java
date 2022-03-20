package cc.heikafei;

/**
 * 题目：一个整数，它加上100后是一个完全平方数，再加上268又是一个完全平方数，请问该数是多少？
 * 程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。
 */
public class myPractice13 {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i <= 100000; i++) {
            if (isCompSqrt(i + 100) && isCompSqrt(i + 268)) {
                a = i;
                break;
            }
        }
        System.out.println("所求的数为：" + a);
    }

    private static boolean isCompSqrt(int a) {
        boolean isComp = false;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a == Math.pow(i, 2)) {
                isComp = true;
                break;
            }
        }
        return isComp;
    }
}
