package cc.heikafei.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * LogTest
 */
@Slf4j
public class LogTest {

    @Test
    public void test() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            log.error("code={},msg={}",500,"呜呜，业务出错了");
        }
    }
}
