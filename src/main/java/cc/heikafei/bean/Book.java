package cc.heikafei.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Book
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/19 11:48
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("book")
public class Book {

    @Value("First Java")
    private String name;

    @Value("330")
    private int pages;
}
