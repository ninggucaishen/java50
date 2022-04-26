package cc.heikafei.myPractice;

public class StringTest {
    public static void main(String[] args) {
        String str = "hello,ning";
        //子串截取，左闭右开原则
        String s = str.substring(4, 7);
        System.out.println(s);      //o,n
    }
}
