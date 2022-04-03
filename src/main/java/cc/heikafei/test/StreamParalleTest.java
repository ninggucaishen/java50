package cc.heikafei.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 并行Stream测试
 */
public class StreamParalleTest {

    private static int total = 100000000;

    public static void main(String[] args) {

//        streamPrarlle();

        reduceTest();

    }

    private static void reduceTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    private static void streamPrarlle() {
        System.out.println(String.format("本计算机的核数：%d", Runtime.getRuntime().availableProcessors()));

        //产生1000w个随机数（1-100），组成列表
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>(total);

        for (int i = 0; i < total; i++) {
            list.add(random.nextInt(100));
        }

        long prevTime = getCurrentTime();
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("单线程计算耗时：%d", getCurrentTime() - prevTime));

        prevTime = getCurrentTime();
        //只需加上.parallel()就行了
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("多线程计算耗时：%d", getCurrentTime() - prevTime));
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
