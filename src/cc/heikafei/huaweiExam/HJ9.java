package cc.heikafei.huaweiExam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //使用HashSet来判断是否重复
        while (sc.hasNext()) {
            HashSet<Integer> hs = new HashSet<>();
            int target = sc.nextInt();      //获取待求解的值
            while (target != 0) {       //求解每位上面的整数
                int temp = target % 10;
                if (hs.add(temp))       //如果能加入，则说明没有重复
                    System.out.print(temp);
                target /= 10;       //除10-->去掉最右边的数字
            }
            System.out.println();
        }
    }
}
