package cc.heikafei;

import java.util.Scanner;

/**
 * 古典问题：
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
 * 程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class myPractice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int mounth = scanner.nextInt();
        System.out.println("第" + mounth + "个月兔子总数为：" + fun(mounth));
    }

    private static int fun(int mounth) {
        if (mounth == 1 || mounth == 2) {
            return 1;
        } else {
            return fun(mounth - 1) + fun(mounth - 2);
        }
    }

}
