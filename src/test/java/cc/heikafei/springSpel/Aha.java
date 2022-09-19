package cc.heikafei.springSpel;

import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName Aha
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/26 17:01
 * @Version 1.0
 */
public class Aha {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("Java");
        books.add("ios");
        books.add("Android");

        for (Object obj : books) {
            System.out.println(obj);
        }

        System.out.println("-----------");

        if (books.equals("ios")) {
            books.remove(books);
        }

        System.out.println(books);

    }
}
