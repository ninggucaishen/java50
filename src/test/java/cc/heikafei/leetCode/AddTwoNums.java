package cc.heikafei.leetCode;

/**
 * @ClassName AddTwoNums
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/3 8:54
 * @Version 1.0
 */
public class AddTwoNums {

    public static int[] add(int[] l1, int[] l2) {


        //将l1数组转换成整数
        int a = 0;
        for (int i = 0; i < l1.length; i++) {
            a = a * 10 + l1[i];
        }
        //将l2数组装换成整数
        int b = 0;
        for (int i = 0; i < l2.length; i++) {
            b = b * 10 + l2[i];
        }
        //
        int c = a + b;
        String str = String.valueOf(c);
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int temp = c % 10;
            c /= 10;
            arr[i] = temp;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] l1 = new int[]{2, 4, 3};
        int[] l2 = new int[]{5, 6, 4};
        add(l1, l2);
    }
}
