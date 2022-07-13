package cc.heikafei;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @ClassName SpelTest
 * @Description Spring Spel测试
 * @Auther Ning
 * @Date 2022/7/13 18:02
 * @Version 1.0
 */
public class SpelTest {

    @Test
    public void test1() {

        //创建解析器
        ExpressionParser parser = new SpelExpressionParser();

        //解析表达式
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");

        //构造上下文
        EvaluationContext context = new StandardEvaluationContext();

        //求值
        context.setVariable("end", "!");

        System.out.println(expression.getValue(context));
    }

    @Test
    public void testParserContext() {

        //创建解析器
        ExpressionParser parser = new SpelExpressionParser();

        //构造、解析上下文
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {    //打开开关解析上下文
                return true;
            }

            @Override
            public String getExpressionPrefix() {    //获取前缀
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {     //获取后缀
                return "}";
            }
        };
        String template = "#{'Hello '}#{'World!'}";

        //解析表达式
        Expression expression = parser.parseExpression(template, parserContext);

        System.out.println(expression.getValue());
    }

    @Test
    public void test2() {
        ExpressionParser parser = new SpelExpressionParser();

        String str1 = parser.parseExpression("'Hello World!'").getValue(String.class);
        int int1 = parser.parseExpression("1").getValue(Integer.class);
        long long1 = parser.parseExpression("-1L").getValue(long.class);
        float float1 = parser.parseExpression("1.1").getValue(Float.class);
        double double1 = parser.parseExpression("1.1E+2").getValue(double.class);
        int hex1 = parser.parseExpression("0xa").getValue(Integer.class);
        long hex2 = parser.parseExpression("0xaL").getValue(long.class);
        boolean true1 = parser.parseExpression("true").getValue(boolean.class);
        boolean false1 = parser.parseExpression("false").getValue(boolean.class);
        Object null1 = parser.parseExpression("null").getValue(Object.class);

        System.out.println("str1 = " + str1);
        System.out.println("int1 = " + int1);
        System.out.println("long1 = " + long1);
        System.out.println("float1 = " + float1);
        System.out.println("double1 = " + double1);
        System.out.println("hex1 = " + hex1);
        System.out.println("hex2 = " + hex2);
        System.out.println("true1 = " + true1);
        System.out.println("false1 = " + false1);
        System.out.println("null1 = " + null1);
    }

    @Test
    public void test3() {

        ExpressionParser expressionParser = new SpelExpressionParser();

        //加减乘除
        int result1 = expressionParser.parseExpression("1+2-3*4/2").getValue(Integer.class);
        System.out.println(result1);

        //求余
        int result2 = expressionParser.parseExpression("4%3").getValue(Integer.class);
        System.out.println(result2);

        //幂运算
        int result3 = expressionParser.parseExpression("2^3").getValue(Integer.class);
        System.out.println(result3);
    }

    @Test
    public void test4() {

        ExpressionParser parser = new SpelExpressionParser();

        boolean v1 = parser.parseExpression("1 GT 2").getValue(boolean.class);
        System.out.println(v1);

        boolean between1 = parser.parseExpression("1 between {1,2}").getValue(boolean.class);
        System.out.println(between1);


        //SpEL同样提供了等价的“EQ” 、“NE”、 “GT”、“GE”、 “LT” 、“LE”来表示
        //                   等于、不等于、大于、大于等于、小于、小于等于，不区分大小写
        boolean result1 = parser.parseExpression("2>1 and (!true or !false)").getValue(boolean.class);
        System.out.println("result1 = " + result1);

        boolean result2 = parser.parseExpression("2>1 && (!true || !false)").getValue(boolean.class);
        System.out.println("result2 = " + result2);

        boolean result3 = parser.parseExpression("2>1 and (NOT true or NOT false)").getValue(boolean.class);
        System.out.println("result3 = " + result3);

        boolean result4 = parser.parseExpression("2>1 && (NOT true || NOT false)").getValue(boolean.class);
        System.out.println("result4 = " + result4);
    }

}
