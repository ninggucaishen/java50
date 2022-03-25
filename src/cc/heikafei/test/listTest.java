package cc.heikafei.test;

import java.util.ArrayList;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");

        for (int i = 0; i < list.size(); i++) {
            String ls = list.get(i);
            System.out.println(ls);
        }
        
        System.out.println(list);
        System.out.print(list.get(0));

        //List.of()是jdk9中新添加的
        //List<String> ls = List.of("apple", "orange", "banana");
    }
}
