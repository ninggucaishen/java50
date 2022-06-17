package cc.heikafei.myPractice;

public class Test {
    /*public static void main(String[] args) {

    }

    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public Test() {
        System.out.println("无参构造方法");
    }*/

    /**
     * 格式化字符串,添加单字符
     *
     * @param str      原字符串
     * @param sstr     单字符串
     * @param totalLen 结果总长
     * @param isappend 是否附加,true:加在后面,false:加在前面
     * @return String 格式化的字符串
     */
    public static String addSingleStr(String str, String sstr, int totalLen, boolean isappend) {
        if (str == null) str = "null";
        if (sstr == null && sstr.length() != 1) return str;
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        if (!isappend) sb.append(str);
        for (int i = 0; i < totalLen - len; i++) {
            sb.append(sstr);
        }
        if (isappend) sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = addSingleStr("", "N", 10, false);    //NNNNNNNNNN
        //String s = addSingleStr("", "N", 10, true);    //NNNNNNNNNN
        //String s = addSingleStr("", "", 10, true);    //
        //String s = addSingleStr("", "", 10, false);    //
        //String s = addSingleStr("hello", "", 10, false);    //hello
        //String s = addSingleStr("hello", "", 10, true);    //hello
        String s = addSingleStr("hello", "NJ", 10, false);  //helloNJNJNJNJNJ
        //String s = addSingleStr("hello", "NJ", 10, true);  //NJNJNJNJNJhello
        //String s = addSingleStr("hello", "N", 10, true);    //NNNNNhello
        //String s = addSingleStr("hello", "N", 10, false);   //helloNNNNN
        System.out.println(s);
    }

}
