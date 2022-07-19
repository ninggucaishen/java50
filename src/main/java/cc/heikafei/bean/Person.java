package cc.heikafei.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Person
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/19 11:48
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("person")
public class Person {

    @Value("#{book}")
    private Book book;

    @Value("#{book.name}")
    private String bookName;
}
