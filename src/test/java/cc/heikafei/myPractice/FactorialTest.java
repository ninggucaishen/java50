package cc.heikafei.myPractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 * JUnit测试
 */
public class FactorialTest {

    Factorial factorial;

    @BeforeEach
    public void setUp() {
        this.factorial = new Factorial();
    }

    @AfterEach
    public void tearDown() {
        this.factorial = null;
    }

    @Disabled       //条件测试
    @Test
    public void testFactorial() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }

    @Test
    public void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.fact(-1);
        });
    }

}
