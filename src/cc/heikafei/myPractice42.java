package cc.heikafei;

/**
 * 题目：809*??=800*??+9*??+1
 * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。
 */
public class myPractice42 {
    public static void main(String[] args) {
        int n = 0;
        boolean flag = false;
        for (int i = 10; i < 100; i++) {
            if ((809 * i == 800 * i + 9 * i + 1) && (8 * i < 100) && (9 * i > 100)) {
                flag = true;
                n = i;
                break;
            }
        }
        if (flag)
            System.out.println(n);
        else
            System.out.println("无符合要求的数！");
    }
}
