package cc.heikafei.se50;

/**
 * 题目：打印出如下图案（菱形）
 *     *
 *    ***
 *   *****
 *  *******
 *   *****
 *    ***
 *     *
 * 程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，利用双重 for循环，第一层控制行，第二层控制列。
 */
public class myPractice19 {

    public static void main(String[] args) {
        printStar(6);
    }

    public static void printStar(int size) {
        if (size % 2 == 0) {
            size++;      // 计算菱形大小
        }
        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" ");      // 输出左上角位置的空白
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");       // 输出菱形上半部边缘
            }
            System.out.println();       // 换行
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" ");      // 输出菱形左下角空白
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                System.out.print("*");      // 输出菱形下半部边缘
            }
            System.out.println();        // 换行
        }
    }

}
