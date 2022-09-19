package cc.heikafei.File;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @ClassName SpelTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/24 16:36
 * @Version 1.0
 */
public class SpelTest {

    @Autowired
    SpelParser spelParser;

    @Test
    public void testSpel() {
        SpelParser spelParser = SpelParser.getSingleSpelParser();
        JSONObject source = JSONUtil.readJSONObject(new File("src/test/java/cc/heikafei/File/source.json"), Charset.defaultCharset());
        //String template = "订单 %{orderL1Id} 的 %{taskTemplateName} 环节已发生故障，请尽快处理！";
        String template = "#{ orderL1Id } 订单的 #{ taskTemplateName } 环节已发生故障，请尽快处理！";

        String desc = spelParser.parse(template, source);
        System.out.println(desc);

        /*SpelExpressionParser parser = new SpelExpressionParser();

        TemplateParserContext context = new TemplateParserContext("%{", "}");
        Expression expression = parser.parseExpression("订单 %{#orderL1Id} 的 %{#taskTemplateName} 环节已发生故障，请尽快处理！",context);

        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("orderL1Id", "12312313");
        evaluationContext.setVariable("taskTemplateName", "信通院");

        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(value);*/

        /*//创建解析器
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
        System.out.println(value);*/
    }
}
