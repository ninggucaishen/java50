package cc.heikafei.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator迭代器测试
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            //next返回的元素是Object类型，因此需要强转
            int num = (int) iter.next();
            if (num == 2) {
                iter.remove();
            }
            System.out.println(num);
        }
        System.out.println("删除之后的集合为：" + list);
    }
}
