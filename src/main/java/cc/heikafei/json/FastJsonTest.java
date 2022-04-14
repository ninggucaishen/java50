package cc.heikafei.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * fastJson 测试
 */
public class FastJsonTest {
    public static void main(String[] args) {
        fastJson();
    }

    private static void fastJson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 21, new Date()));
        list.add(new Person("Bob", 22, new Date()));

        String string = JSONArray.toJSONString(list);
        System.out.println(string);
    }

    //测试类
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Person {
        @JSONField(name = "FULL NAME")
        private String fullname;

        @JSONField(name = "AGE")
        private int age;

        @JSONField(name = "BIRTHDAY",format = "yyyy/MM/dd")
        private Date birthday;
    }

}
