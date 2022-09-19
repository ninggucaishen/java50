package cc.heikafei.leetCode;

import java.util.ArrayDeque;

/**
 * @ClassName palindromeInteger
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/2 9:57
 * @Version 1.0
 */
public class palindromeInteger {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            System.out.println("不是回文数");
            return false;
        }

        String a = x + "";
        int[] arr = new int[a.length() / 2];
        int[] arr1 = new int[a.length() / 2];

        if (a.length() == 1) {
            System.out.println("是回文数");
            return true;
        }

        for (int i = 0; i < a.length() / 2; i++) {
            Character ch = a.charAt(i);
            arr[i] = Integer.parseInt(ch.toString());
            int temp = x % 10;
            x /= 10;
            arr1[i] = temp;
            if (arr[i] != arr1[i]) {
                System.out.println("不是回文数");
                return false;
            }
        }
        System.out.println("是回文数");
        return true;

        /*String a = x + "";
        int arr[] = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            int temp = x % 10;
            x /= 10;
            arr[i] = temp;
        }
        for (int i = 0; i < a.length(); i++) {
            if (arr[i] != arr[a.length() - i - 1]) {
                return false;
            }
        }
        return true;*/

        /*String a = x + "";
        int[] arr = new int[a.length()];
        int[] arr1 = new int[a.length()];

        if (a.length() == 1) {
            System.out.println("是回文数");
            return true;
        }

        for (int i = 0; i < a.length() / 2; i++) {
            Character ch = a.charAt(i);
            arr[i] = Integer.parseInt(ch.toString());
            int temp = x % 10;
            x /= 10;
            arr1[i] = temp;
            if (arr[i] != arr1[i]) {
                System.out.println("不是回文数");
                return false;
            }
        }
        System.out.println("是回文数");
        return true;*/

        /*String a = x + "";
        int[] b = new int[a.length()];
        //转数组
        int[] arr = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            Character ch = a.charAt(i);
            arr[i] = Integer.parseInt(ch.toString());
        }
        //反转
        for (int i = 0; i < a.length(); i++) {
            int temp = x % 10;  //取最后一位
            x /= 10;
            b[i] = temp;
        }
        if (a.length() == 1) {
            System.out.println("是回文数");
            return true;
        }
        //比较
        for (int i = 0; i < a.length() / 2; i++) {
            if (arr[i] != b[i]) {
                System.out.println("不是回文数");
                return false;
            }
        }*/

        /*String a = x + "";
        String b = new StringBuffer(a).reverse().toString();
        if (a.equals(b)) {
            System.out.println("是回文数");
            return true;
        }*/

        //System.out.println("是回文数");
        //return true;
    }

    public static void main(String[] args) {
        isPalindrome(123123);
        first(1104);
    }

    public static int first(int x) {

        // 最后一位
        System.out.println(x % 10);

        int m = 1;
        for (int i = 0; i < (int) Math.log10(x); i++) {
            m *= 10;
        }
        // 第一位
        System.out.println(x / m);
        return x / m;
    }
}
