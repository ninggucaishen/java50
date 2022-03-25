package cc.heikafei.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("zs", "ls", "wu", "zl");
        stream.forEach(System.out::println);

        Stream<String> stream1 = Arrays.stream(new String[]{"zhangsan", "lisi", "wangwu", "zhaoliu"});
        stream1.forEach(System.out::println);

        IntStream is = Arrays.stream(new int[]{1, 2, 3});
        is.forEach(System.out::println);
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        LongStream ls = list.stream().mapToLong(Long::parseLong);*/

        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s1 = s.map(n -> n * n);
        s1.forEach(System.out::println);
    }
}
