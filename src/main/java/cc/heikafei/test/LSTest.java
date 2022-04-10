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

        //线程中使用lambda表达式
        new Thread(() -> {
            System.out.println("hello");
            System.out.println("ning");
        }).start();

        ComsumerInterface<String> comsumer = str -> System.out.println(str);
        System.out.println(comsumer);

        //reduce操作可以实现从一组元素中生成一个值
        reduceTest();

        collectionTest2();

        //forEach 循环遍历，筛选符合条件的结果
        forEachTest();

        //使用迭代器删除列表元素
        remove();

        //使用removeIf()结合Lambda表达式 实现 删除列表元素
        removeIf();

        //使用下标实现元素替换
        replace();

        //使用lambda表达式实现元素替换
        replaceAll();

    }

    private static void replaceAll() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.replaceAll(e -> {
            if (e.length() >= 3) {
                return e.toUpperCase(Locale.ROOT);
            }
            return e;
        });
        System.out.println(list);
    }

    private static void replace() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.length() > 3) {
                list.set(i, str.toUpperCase(Locale.ROOT));
            }
        }
        System.out.println(list);
    }

    private static void removeIf() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(e -> e.length() > 3);
        System.out.println(list);
    }

    private static void remove() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() > 3) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void forEachTest() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.forEach(e -> {
            if (e.length() > 3)
                System.out.println(e);
        });
    }

    private static void collectionTest2() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        //方法一：将Stream转成List
//        ArrayList<Object> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //方法二：将Stream转成List
//        List<String> list = stream.collect(Collectors.toList());
//        System.out.println(list);       //[I, love, you, too]

        //将Stream转成Set
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void reduceTest() {
        //找出最长的单词
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(longest.get());
    }

    //自定义函数接口
    @FunctionalInterface
    private interface ComsumerInterface<T> {
        void accept(T t);
    }

    private static void test() {
        Arrays.asList(" ", "b2", "c3")
                .stream()       //创建流
                .findFirst()        //找到第一个元素的位置
                .ifPresent(System.out::println);        //第一个位置没有元素，则不输出
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
