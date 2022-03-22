package cc.heikafei;

/**
 * 题目：计算字符串中子串出现的次数
 */
public class myPractice49 {
    public static void main(String[] args) {
        String str = "abcacacacaaacab";
        String subStr = "ab";
        int count = getStringCount(str, subStr);
        System.out.println("该字符串中子串出现的次数为：" + count);
    }

    private static int getStringCount(String str, String subStr) {

        int count = 0;
        for (int i = 0; i < str.length() - subStr.length() + 1; i++) {
            if (str.substring(i, subStr.length() + i).equals(subStr)) {
                count++;
            }
        }
        return count;
    }
}
