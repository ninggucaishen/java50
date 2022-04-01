package cc.heikafei.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Lambda & Stream 联合测试二
 */
public class LSTest {
    public static void main(String[] args) {
        filter();
    }

    private static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> evenIntegers = list.stream().filter(i -> i.intValue() % 2 == 0);
        Stream<Integer> oddIntegers = list.stream().filter(i -> i.intValue() % 2 != 0);
        evenIntegers.forEach(n -> System.out.print(n + " "));
        System.out.println();
        oddIntegers.forEach(n -> System.out.print(n + " "));
    }
}
