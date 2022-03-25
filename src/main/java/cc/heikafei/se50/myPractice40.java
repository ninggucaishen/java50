package cc.heikafei.se50;

/**
 * 输入一个或自己定义（英文）字符串数组，按照字母表的降序对这些字符串进行排序。
 */
public class myPractice40 {
    public static void main(String[] args) {
        String[] str = {"abc", "cad", "m", "fa", "f"};
        for (int i = str.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (str[j].compareTo(str[j + 1]) < 0) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }
            }
        }
        for (String subStr : str) {
            System.out.print(subStr + " ");
        }
    }
}
