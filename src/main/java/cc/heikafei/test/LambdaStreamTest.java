package cc.heikafei.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
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

        //peek
        //建立一个通道，在这个通道中对 Stream 的每个元素执行对应的操作，对应 Consumer<T>的函数式接口，这是一个消费者函数式接口
        Stream<String> stream10 = Stream.of("a", "b", "c", "d", "f");
        List<String> list = stream10.peek(n -> System.out.print(n.toUpperCase())).collect(Collectors.toList());
        System.out.println(list);

        //forEach
        //和 peek 方法类似，都接收一个消费者函数式接口，可以对每个元素进行对应的操作，
        // 但是和 peek 不同的是，forEach 执行之后，这个 Stream 就真的被消费掉了，之后这个 Stream 流就没有了，不可以再对它进行后续操作了，
        // 而 peek操作完之后，还是一个可操作的 Stream 对象。
        Stream<String> stream11 = Stream.of("a", "b", "c", "d");
        stream11.forEach(n -> System.out.print(n.toUpperCase(Locale.ROOT)));

        System.out.println();

        //limit
        //获取前 n 条数据，类似于 MySQL 的limit，只不过只能接收一个参数，就是数据条数。
        Stream<String> stream12 = Stream.of("hello", "ning", "welcome", "to", "changsha");
        stream12.limit(2).forEach(s -> System.out.print(s));

        System.out.println();

        //skip
        //跳过前 n 条数据
        Stream<String> stream13 = Stream.of("hello", "ning", "welcome", "to", "changsha");
        stream13.skip(2).forEach(s -> System.out.print(s));

        System.out.println();

        //distinct
        //元素去重
        Stream<String> stream14 = Stream.of("hello", "ning", "and", "hello", "kangkang");
        stream14.distinct().forEach(s -> System.out.print(s));

        System.out.println();

        //sorted
        // 有两个重载，一个无参数，另外一个有个 Comparator类型的参数。
        //无参类型的按照自然顺序进行排序，只适合比较单纯的元素，比如数字、字母等
        sorted();

        System.out.println();

        //sorted()
        //有参数的需要自定义排序规则，
        // 例如下面这个方法，按照第二个字母的大小顺序排序
        sortedWithComparator();

        System.out.println();

        //filter
        //用于条件筛选过滤，筛选出符合条件的数据
        filter();

    }

    private static void sorted() {
        Stream<String> a = Stream.of("a", "c", "b");
        a.sorted().forEach(e -> System.out.print(e + " "));
    }

    private static void sortedWithComparator() {
        Stream<String> stream = Stream.of("a3", "a1", "c3", "h4", "f4", "b2", "e8");
        stream.sorted((x, y) -> Integer.parseInt(x.substring(1)) > Integer.parseInt(y.substring(1)) ? 1 : -1).forEach(n -> System.out.print(n + " "));
    }


    //模拟用户数据
    private static List<User> getUserData() {
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            //封装方式一：手动封装
            /*User user = new User();
            user.setId(i);
            user.setName(String.format("ning's %s 号小弟", i));
            user.setAge(random.nextInt(50));
            user.setGender("male");
            user.setPhone("13378762341");
            user.setAddress("None");
            users.add(user);*/

            //封装方式二：采用（全参）构造方法封装
            User user = new User(i,String.format("ning's %s 号小弟",i),random.nextInt(50),"male",null,"None");
            users.add(user);
        }
        return users;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class User {
        private Integer id;
        private String name;
        private Integer age;
        private String gender;
        private String phone;
        private String address;
    }

    private static void filter() {
        List<User> users = getUserData();
        Stream<User> stream = users.stream();
        //删选性别为male、年龄小于30的小弟
        stream.filter(user -> user.getGender().equals("male") && user.getAge() < 30).forEach(n -> System.out.println(n));
    }

}
