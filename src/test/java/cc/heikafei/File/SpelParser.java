package cc.heikafei.File;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author 陈敏
 * @version SpelParser.java, v 1.1 2021/4/27 15:06 chenmin Exp $
 * Created on 2021/4/27
 *
 */
public class SpelParser {

    private ExpressionParser expressionParser;
    private ParserContext parserContext;
    private EvaluationContext evaluationContext;

    public String parse(String template, String source) {
        return this.parse(template, JSONUtil.parse(source), String.class);
    }

    public String parse(String template, JSON source) {
        return this.parse(template, source, String.class);
    }

    public String parse(JSON template, JSON source) {
        return this.parse(template.toString(), source, String.class);
    }

    public String parse(JSON template) {
        return this.parse(template.toString(), String.class);
    }

    public String parse(String template, JSONObject object) {
        return this.parse(template, String.class);
    }

    public <T> T parse(String template, Object source, Class<T> clazz) {
        Expression expression = expressionParser.parseExpression(template, parserContext);
        return expression.getValue(evaluationContext, source, clazz);
    }

    public <T> T parse(String template, Class<T> clazz) {
        Expression expression = expressionParser.parseExpression(template, parserContext);
        //getValue有参数ctx，从新的容器中根据SpEL表达式获取所需的值
        return expression.getValue(evaluationContext, clazz);
    }

    /**
     * SPEL表达式解析器
     */
    private static volatile SpelParser spelParser;

    /**
     * 获取单例SpelParser对象
     * @return spelParser单例对象
     */
    public static SpelParser getSingleSpelParser() {
        if (spelParser == null) {
            synchronized (SpelParser.class) {
                if (spelParser == null) {
                    spelParser = SpelParser.initSpelParser();
                    return spelParser;
                } else {
                    return spelParser;
                }
            }
        } else {
            return spelParser;
        }
    }

    public static SpelParser initSpelParser() {
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        SpelParser spelParser = new SpelParser();
        if (ObjectUtil.isNotEmpty(applicationContext)) {
            spelParser.setEvaluationContext(applicationContext.getBean(EvaluationContext.class));
            spelParser.setExpressionParser(applicationContext.getBean(ExpressionParser.class));
        } else {
            StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
            evaluationContext.addPropertyAccessor(new JsonPropertyAccessor());
            spelParser.setExpressionParser(new SpelExpressionParser(new SpelParserConfiguration()));
            spelParser.setEvaluationContext(evaluationContext);
        }
        spelParser.setParserContext(new ParserContext() {

            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        });
        return spelParser;
    }

    public ExpressionParser getExpressionParser() {
        return expressionParser;
    }

    public SpelParser setExpressionParser(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
        return this;
    }

    public ParserContext getParserContext() {
        return parserContext;
    }

    public SpelParser setParserContext(ParserContext parserContext) {
        this.parserContext = parserContext;
        return this;
    }

    public EvaluationContext getEvaluationContext() {
        return evaluationContext;
    }

    public SpelParser setEvaluationContext(EvaluationContext evaluationContext) {
        this.evaluationContext = evaluationContext;
        return this;
    }

    public static SpelParser getSpelParser() {
        return spelParser;
    }

    public static void setSpelParser(SpelParser spelParser) {
        SpelParser.spelParser = spelParser;
    }
}
