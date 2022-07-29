package cc.heikafei.myPractice;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName RandomTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/27 15:11
 * @Version 1.0
 */
public class RandomTest {

    public static void main(String[] args) {
        System.out.println(getRandom(4));

        Date date = new Date();

        String currentTime = new SimpleDateFormat("yyyyMMddHH").format(date);
        System.out.println(currentTime);
        System.out.println(currentTime + getRandom(4));
        System.out.println((Timestamp) date);
    }

    private static String getRandom(int len) {
        String source = "0123456789";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(source.charAt(r.nextInt(10)));
        }
        return sb.toString();
    }

}
