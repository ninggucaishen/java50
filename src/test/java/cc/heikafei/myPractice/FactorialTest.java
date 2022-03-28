package cc.heikafei.myPractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**
 * JUnit测试
 */
public class FactorialTest {

    @Test
    public void testFactorial() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}
