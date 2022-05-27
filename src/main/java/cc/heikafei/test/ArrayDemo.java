package cc.heikafei.test;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] data = {3, 6, 1, 2, 8, 0};
        //System.out.println(data);
        //java.util.Arrays.sort(data);
        print(data);
    }

    private static void print(int temp[]) {
        for (int i = 0; i < temp.length; i++) {
            Arrays.sort(temp);
            System.out.print(temp[i] + ",");
        }
    }
}
