package cc.heikafei.jsonTest;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FastJsonTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 17:41
 * @Version 1.0
 */
public class FastJsonTest {

    private List<Student> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add(new Student("ning", 18, new Date()));
        list.add(new Student("hai", 17, new Date()));
    }

    @Test
    public void test() {
        String jsonOutput = JSON.toJSONString(list);
        System.out.println(jsonOutput);
    }
}
