package cc.heikafei.springSpel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Auther Ning
 * @Date 2022/7/15 9:41
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Car car;

    @Override
    public String toString() {
        return "User{" +
                "Car=" + car +
                '}';
    }
}
