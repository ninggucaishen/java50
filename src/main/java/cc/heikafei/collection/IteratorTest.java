package cc.heikafei.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        //集合自带的remove()
        //不要再迭代器迭代过程中使用这个
        //for (Object o : list) {
        //    if ("3".equals(o)) {
        //        list.remove(o);
        //    }
        //}

        //迭代器自带的remove()
        //写法一
        //for (Iterator iter = list.iterator(); iter.hasNext(); ) {
        //    if ("3".equals(iter.next())) {
        //        iter.remove();
        //    }
        //}

        //写法二
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            if ("3".equals(iter.next())) {
                iter.remove();
            }
        }

        System.out.println(list);
    }
}
