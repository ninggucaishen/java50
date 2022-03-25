package cc.heikafei.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");

        //遍历方法一
        for (int i = 0; i < list.size(); i++) {
            String ls = list.get(i);
            System.out.println(ls);
        }

        //遍历方法二
        for (String s : list) {
            System.out.println(s);
        }

        //遍历方法三：使用
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String l = it.next();
            System.out.println(l);
        }
        
        System.out.println(list);
        System.out.print(list.get(0));

        //List.of()是jdk9中新添加的
        //List<String> ls = List.of("apple", "orange", "banana");
    }
}
