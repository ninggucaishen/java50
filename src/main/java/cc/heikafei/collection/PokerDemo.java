package cc.heikafei.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * A:创建一个HashMap集合
 * B:创建一个ArrayList集合
 * C:装牌
 * D:洗牌
 * E:发牌
 * F:看牌
 */
public class PokerDemo {
    public static void main(String[] args) {
        //创建一个HashMap集合
        HashMap<Integer, String> hm = new HashMap<>();

        //创建一个ArrayList集合
        ArrayList<Integer> array = new ArrayList<>();

        //存储牌
        //定义花色数组
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义点数数组
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //定义一个索引
        int key = 0;

        for (String number : numbers) {
            for (String color : colors) {
                String value = color.concat(number);
                hm.put(key, value);
                array.add(key);
                key++;
            }
        }

        hm.put(key, "小王");
        array.add(key);
        hm.put(key, "大王");
        array.add(key);

        //洗牌
        Collections.shuffle(array);

        //发牌
        TreeSet<Integer> zs = new TreeSet<>();
        TreeSet<Integer> ls = new TreeSet<>();
        TreeSet<Integer> wu = new TreeSet<>();
        TreeSet<Integer> dp = new TreeSet<>();

        for (int i = 0; i < array.size(); i++) {
            if (i >= array.size() - 3) {
                dp.add(array.get(i));
            } else if (i % 3 == 0) {
                zs.add(array.get(i));
            } else if (i % 3 == 1) {
                ls.add(array.get(i));
            } else if (i % 3 == 2) {
                wu.add(array.get(i));
            }
        }

        //看牌
        lookPoker("张三", zs, hm);
        lookPoker("李四", ls, hm);
        lookPoker("王五", wu, hm);
        lookPoker("底牌", dp, hm);
    }

    private static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + "底牌是：");
        for (Integer key : ts) {
            String value = hm.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
