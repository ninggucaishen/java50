package cc.heikafei.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @ClassName Employee
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/19 15:13
 * @Version 1.0
 */

@Data
@Configuration
@PropertySource(name = "employeeProperties", value = "classpath:employee.properties", encoding = "utf-8")
public class Employee {

    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;
}
