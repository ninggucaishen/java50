package cc.heikafei.File;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @ClassName SpTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/25 11:13
 * @Version 1.0
 */
public class SpTest {

    @Test
    public void testSpel() {
        //创建解析器
        SpelExpressionParser parser = new SpelExpressionParser();

        //创建解析器上下文
        ParserContext context = new TemplateParserContext("%{", "}");
        Expression expression = parser.parseExpression("你好：%{#name}, 我们正在学习：%{#lesson}", context);

        //创建表达式计算上下文
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("name", "ning");
        evaluationContext.setVariable("lesson", "spring spelExpression");

        //获取值
        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(value);
    }
}
