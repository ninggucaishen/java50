package cc.heikafei;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * 程序分析：利用辗除法。
 */
public class myPractice6 {
    public static void main(String[] args) {
        /*ArrayList<Object> objects = new ArrayList<>();
        objects.add("zs");
        objects.add("ls");
        objects.add("ww");
        objects.add(3, "zl");
        objects.add("ning");
        objects.remove(2);
        System.out.println(objects.size());
        System.out.println(objects.get(2));
        System.out.println(objects.getClass());
        System.out.println(objects);*/

        UUID uuid = UUID.randomUUID();
        int variant = uuid.variant();
        int version = uuid.version();
        System.out.println(variant);
        System.out.println(version);
    }
}
