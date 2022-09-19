package cc.heikafei.problem;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/22 8:46
 * @Version 1.0
 */
public class TestTime {

    @Test
    public void testTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String localTime = dateFormat.format(new Date());
        System.out.println(localTime);
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println("¥Ú”°–≈œ¢=====");
        System.out.println(calendar);
    }
}
