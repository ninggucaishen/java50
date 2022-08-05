package cc.heikafei.jsonTest;

import java.util.HashMap;

/**
 * @ClassName Ex
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 22:52
 * @Version 1.0
 */
public class Ex {

    private static HashMap<Integer, String> map = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {
        map.put(5, "C");

        /*
         *可能会出现如下结果，这种情况说明HashMap为线程不安全
         *
         * {5=C, 7=B, 3=A}
         * {5=C, 7=B, 3=A}
         *
         */
        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }
        }.start();

        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        }.start();
    }
}
