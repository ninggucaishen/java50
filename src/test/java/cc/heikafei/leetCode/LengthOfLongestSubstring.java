package cc.heikafei.leetCode;

import java.util.HashMap;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description TODO
 * @Auther Ning
 * @Date 2022/9/6 21:37
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    public static int leng(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    public static void main(String[] args) {
        leng("abcabcbb");
    }

}
