package cc.heikafei.jsonTest;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 17:42
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @JSONField(name = "FULL_NAME")
    private String fullName;

    @JSONField(name = "AGE")
    private int age;

    @JSONField(name = "BIRTHDAY")
    private Date birthday;

}
