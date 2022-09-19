package cc.heikafei.springSpel;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SpTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/25 15:45
 * @Version 1.0
 */
public class SpTest {

    private static final SpelExpressionParser parser= new SpelExpressionParser();

    private static final ConcurrentHashMap<String, Expression> expressionMap = new ConcurrentHashMap<>(256);

    public static void main(String[] args) {
        String el = "student.address.city";

        Map<String, Object> address = new HashMap<>();
        address.put("city", "Nanking");
        Map<String, Object> student = new HashMap<>();
        student.put("address", address);
        Map<String, Object> root = new LinkedHashMap<>();
        root.put("student", student);


        Expression expression = getExpression(el);

        StandardEvaluationContext context = new StandardEvaluationContext(root);
        //这里很关键，如果没有配置MapAccessor，那么只能用['c']['a']这种解析方式
        context.addPropertyAccessor(new MapAccessor());

        Object value = expression.getValue(context);
        System.out.println(value);
    }

    private static Expression getExpression(String el) {
        Expression expression = expressionMap.get(el);

        if (expression != null) {
            return expression;
        }

        return expressionMap.computeIfAbsent(el, k -> parser.parseRaw(el));
    }

}
