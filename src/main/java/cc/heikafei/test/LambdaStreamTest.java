package cc.heikafei.test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Lambda & Stream 联合测试
 */
public class LambdaStreamTest {
    public static void main(String[] args) {

        //创建Stream方式一
        String[] arr = new String[]{"a", "b", "c", "d"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::print);

        System.out.println();

        //创建Stream方式二
        Stream<String> stream2 = Stream.of("A", "B", "C", "D");
        stream2.forEach(System.out::print);

        //创建一个空的Stream
        Stream<Object> stream = Stream.empty();
        System.out.println(stream.count());

        System.out.println();

        //连接两个Stream,不改变其中任何一个Stream对象，返回一个新的Stream对象
        Stream<String> stream3 = Stream.of("a", "b");
        Stream<String> stream4 = Stream.of("c", "d", "e");
        Stream<String> concat = Stream.concat(stream3, stream4);
        concat.forEach(System.out::print);

        System.out.println();

        //max
        Stream<Integer> stream5 = Stream.of(2, 4, 5, 20, 43, 89, 1000);
        Integer max = stream5.max(Integer::compareTo).get();
        System.out.println(max);

        //min
        Stream<Integer> stream6 = Stream.of(2, 4, 5, 20, 43, 89, 1000);
        Optional<Integer> min = stream6.min(Integer::compareTo);
        System.out.println(min.get());

        //findFirst
        Stream<Integer> stream7 = Stream.of(2, 4, 5, 20, 43, 89, 1000);
        Optional<Integer> first = stream7.findFirst();
        System.out.println(first.get());

        //findAny,获取 Stream 中的某个元素，如果是串行情况下，一般都会返回第一个元素，并行情况下就不一定了。
        Stream<Integer> stream8 = Stream.of(2, 4, 5, 20, 43, 89, 1000);
        Optional<Integer> any = stream8.findAny();
        System.out.println(any);

        //count
        Stream<String> stream9 = Stream.of("ab", "bcd", "ef", "g");
        System.out.println(stream9.count());

    }
}
