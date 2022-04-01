package cc.heikafei.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Lambda & Stream 联合测试二
 */
public class LSTest {
    public static void main(String[] args) {

        filter();

        mapGetKey();

        mapGetValue();
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

}
