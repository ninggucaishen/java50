package cc.heikafei.leetCode;

/**
 * @ClassName preString
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/8 17:41
 * @Version 1.0
 */
public class preString {

    public static void main(String[] args) {
        longesPalindrome2("babad");
    }

    public static String preProcess(String str) {
        int n = str.length();
        if (n == 0) {
            return "^$";
        }

        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + str.charAt(i);
        }
        ret += "#$";
        return ret;
    }

    // 马拉车算法
    public static String longesPalindrome2(String str) {
        String T = preProcess(str);
        int n = T.length();
        int[] P = new int[n];
        int C = 0;
        int R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);    // 防止超出 R
            } else {
                P[i] = 0;   // 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n-1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;     //最开始讲的求原字符串下标
        return str.substring(start, start + maxLen);
    }
}
