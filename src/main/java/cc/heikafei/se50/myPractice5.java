package cc.heikafei.se50;

import java.util.Scanner;

/**
 * 题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 * 程序分析：(a>b)?a:b这是条件运算符的基本例子。
 */
public class myPractice5 {
    public static void main(String[] args) {
        System.out.println("请输入一个分数：");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        scanner.close();
        grade(score);
    }

    private static void grade(int score) {
        if (score < 0 || score > 100) {
            System.out.println("输入无效！");
        } else {
            if (score >= 90) {
                System.out.println("A");
            }
            if (score >= 60 && score < 90) {
                System.out.println("B");
            }
            if (score < 60) {
                System.out.println("C");
            }
        }
    }
}
