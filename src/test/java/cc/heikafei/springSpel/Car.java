package cc.heikafei.springSpel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Car
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/15 9:42
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String name;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
