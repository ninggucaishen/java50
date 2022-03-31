package cc.heikafei.se50;

/**
 * 求100以内的素数
 */
public class myPractice27 {
    public static void main(String[] args) {
        int n = 100;
        System.out.print(n + "以内的素数：");
        for (int i = 2; i < 101; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrime(int n) {
        boolean flag = true;
        for (int i = 2; i < Math.sqrt(101); i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
