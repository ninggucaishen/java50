package cc.heikafei.leetCode;

/**
 * @ClassName TwoSums
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/3 15:47
 * @Version 1.0
 */
public class TwoSums {

    public static void main(String[] args) {
        twoSum(13);
    }

    private static int[] twoSum(int target) {
        int nums[] = {2, 7, 11, 15};
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
