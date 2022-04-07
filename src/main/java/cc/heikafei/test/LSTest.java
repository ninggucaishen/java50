package cc.heikafei.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Lambda & Stream 联合测试二
 */
public class LSTest {
    public static void main(String[] args) {

        filter();

        filter2();

        mapGetKey();

        mapGetValue();

        collectionTest();

        distinctTest();

        mapTest();

        flatMapTest();

        max_minTest();

        //中间操作和终止操作测试，包括rangeTest2()
        rangeTest();

        rangeTest2();

        //Stream PipleLines 测试
        test();

        new Thread(()->{
            System.out.println("hello");
            System.out.println("ning");
        }).start();

    }

    private static void test() {
        Arrays.asList("", "b2", "c3")
                .stream()       //创建流
                .findFirst()        //找到第一个元素的位置
                .ifPresent(System.out::println);        //第一个位置没有元素，则不输出
        System.out.println();
    }

    private static void rangeTest2() {
        IntStream.range(1, 10)
                .peek(e -> System.out.print("\nA" + e))
                .skip(6)
                .peek(e -> System.out.print("B" + e))
                .forEach(e -> System.out.print("C" + e));
        System.out.println();
    }

    private static void rangeTest() {
        IntStream.range(1, 10)
                .peek(e -> System.out.print("A" + e))
                .limit(3)
                .peek(e -> System.out.print("B" + e))
                .forEach(e -> System.out.print("C" + e + "\n"));
        System.out.println();
    }

    private static void max_minTest() {
        List<Integer> list = Arrays.asList(4, 2, 6, 9, 1, 5);
        Optional<Integer> max = list.stream()
                .reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> min = list.stream()
                .reduce(Integer::min);
        System.out.println(min.get());

        System.out.println();
    }

    private static void flatMapTest() {
        List<String> words = Arrays.asList("hello", "ning");
        words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()       //不加distinct()输出helloning，加distinct()输出helonig
                .collect(Collectors.toList())
                .forEach(e -> System.out.print(e));
        System.out.println();
    }

    private static void mapTest() {
        List<Words> list = Arrays.asList(
                new Words("hello"),
                new Words("ning"),
                new Words("welcome to Dashu")
        );

        list.stream()
                .map(Words::getWords)
//                .map(String::length)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Data
    @AllArgsConstructor
    private static class Words {
        private String words;
    }

    private static void distinctTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 2, 1, 3, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    //筛选符合条件的结果
    private static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list);
        Stream<Integer> evenIntegers = list.stream().filter(i -> i.intValue() % 2 == 0);
        Stream<Integer> oddIntegers = list.stream().filter(i -> i.intValue() % 2 != 0);
        evenIntegers.forEach(n -> System.out.print(n + " "));
        System.out.println();
        oddIntegers.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    //filter2
    private static void filter2() {
        List<String> list = Arrays.asList("Alice", "Bob", "Ning", "Tom");
        Stream<String> stream = list.stream()
                .filter(e -> e.contains("n"));
        stream.forEach(System.out::println);
    }

    //测试JavaBean类
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class User {
        Integer id;
        String name;
        String gender;
        Integer age;
        String phone;
        String address;
    }

    //获取Map的Key
    private static void mapGetKey() {
        HashMap<String, String> map = new HashMap<>();
        map.put("jack", "20");
        map.put("ning", "27");

        Optional<String> operationName = map.entrySet().stream()
                .filter(e -> "20".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println(operationName);
    }

    //获取Map的Value
    private static void mapGetValue() {
        HashMap<String, String> map = new HashMap<>();
        map.put("jack", "20");
        map.put("ning", "27");
        map.put("ning", "25");

        System.out.println(map);

        List<String> listAges = map.entrySet().stream()
                .filter(e -> e.getKey().equals("ning"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(listAges);
    }

    private static void collectionTest() {
        List<String> list = Arrays.asList("Alice", "Bob", "Jack", "Tom");
        List<String> duplicateList = Arrays.asList("Alice", "Jack", "Jack", "Tom");

        /*List<String> collect = list.stream().collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = duplicateList.stream().collect(Collectors.toList());
        System.out.println(collect1);*/

        //筛选重复的字段，输出不重复的字段,待改进
        List<String> collect = duplicateList.parallelStream().collect(Collectors.toList());
        System.out.println(collect);

    }

}
