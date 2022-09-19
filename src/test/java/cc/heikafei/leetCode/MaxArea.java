package cc.heikafei.leetCode;

/**
 * @ClassName MaxArea
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/15 22:36
 * @Version 1.0
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        maxArea(a);
    }
}
