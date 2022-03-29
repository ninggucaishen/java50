package cc.heikafei.test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;

/**
 * Lambda表达式测试
 */
public class LambdaTest {
    public static void main(String[] args) {

        //Java8之前的写法
        String[] array = new String[]{"Apple", "Banana", "Lamon", "Orange"};
        //遍历方法一
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("-------------------");

        //遍历方法二
        for (String arr : array) {
            System.out.println(arr);
        }

        System.out.println("-------------------");


        //Java8后的写法
        List<String> list = Arrays.asList("Alice", "Bob", "Jane", "Tom");
        //采用lambda表达式遍历输出
        list.forEach(n -> System.out.println(n));

        System.out.println("-------------------");

        //采用forEach方式遍历输出
        list.forEach(System.out::println);

        List<Integer> prims = Arrays.asList(2, 4, 5, 3, 6, 1, 8, 3, 9, 4);
        IntSummaryStatistics stats = prims.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大值为：" + stats.getMax());
        System.out.println("最小值为：" + stats.getMin());
        System.out.println("总和为：" + stats.getSum());
        System.out.println("平均值为：" + stats.getAverage());

        //String转Integer
        Function<String, Integer> function = Integer::parseInt;
        Integer num = function.apply("1");
        System.out.println(num);

        Function<Integer, String> fun = String::valueOf;
        String str = fun.toString();
        System.out.println(str);

    }
}
