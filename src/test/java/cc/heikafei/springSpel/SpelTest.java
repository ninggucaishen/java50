package cc.heikafei.springSpel;

import cc.heikafei.nettyTest.MyClient;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    @Test
    public void testClassTypeExpression() {
        ExpressionParser parser = new SpelExpressionParser();

        //java.lang包类访问
        Class<?> result1 = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(result1);

        //其他包类访问
        String expression2 = "T(cc.heikafei.nettyTest.MyClient)";
        Class<MyClient> value = parser.parseExpression(expression2).getValue(Class.class);
        System.out.println(value == MyClient.class);

        //对于java.lang包里的可以直接使用“T(String)”访问；其他包必须是类全限定名；
        //可以进行静态字段访问如“T(Integer).MAX_VALUE”；
        //也可以进行静态方法访问如“T(Integer).parseInt('1')”

        //类静态字段访问
        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        System.out.println(result3 == Integer.MAX_VALUE);

        //类静态方法调用
        int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        System.out.println(result4);

    }

    @Test
    public void testConstructorExpression() {
        ExpressionParser parser = new SpelExpressionParser();

        String result1 = parser.parseExpression("new String('hello')").getValue(String.class);
        System.out.println(result1);

        Date date = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date);
        System.out.println(dateString);
    }

    @Test
    public void testVariableExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();

        context.setVariable("name", "ning");
        context.setVariable("age", "22");

        //获取name,age变量
        String name = parser.parseExpression("#name").getValue(context, String.class);
        System.out.println(name);
        String age = parser.parseExpression("#age").getValue(context, String.class);
        System.out.println(age);

        //#this用来访问当前上线文中的对象
        String thisObj1 = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(thisObj1);       //null

        //StandardEvaluationContext构造器传入root对象，可以通过#root来访问root对象
        context = new StandardEvaluationContext("我是root对象");
        String rootObj = parser.parseExpression("#root").getValue(context, String.class);
        System.out.println(rootObj);

        //#this用来访问当前上线文中的对象
        String thisObj = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(thisObj);
    }

    @Test
    public void testFunctionExpression() throws NoSuchMethodException {

        //定义2个函数,registerFunction和setVariable都可以，不过从语义上面来看用registerFunction更恰当
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt1", parseInt);
        context.setVariable("parseInt2", parseInt);

        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("#parseInt1('3')").getValue(context, int.class));
        System.out.println(parser.parseExpression("#parseInt2('3')").getValue(context, int.class));

        String expression = "#parseInt1('3')  == #parseInt2('3')";
        boolean result = parser.parseExpression(expression).getValue(context, boolean.class);
        System.out.println(result);

    }

    @Test
    public void testAssignExpression() {

        Object user = new Object() {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "name='" + name + '\'' +
                        '}';
            }
        };

        {
            //user为root对象
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext(user);
            parser.parseExpression("#root.name").setValue(context, "ning");
            System.out.println(parser.parseExpression("#root").getValue(context, user.getClass()));
        }

        {
            //user为变量
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext();
            context.setVariable("user", user);
            parser.parseExpression("#user.name").setValue(context, "ning");
            System.out.println(parser.parseExpression("#user").getValue(context, user.getClass()));

        }
    }

    @Test
    public void test6() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        User user = new User();
        Car car = new Car();

        car.setName("BYD");
        user.setCar(car);
        factory.registerSingleton("user", user);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(factory));

        ExpressionParser parser = new SpelExpressionParser();
        User userBean = parser.parseExpression("@user").getValue(context, User.class);
        System.out.println(userBean);
        System.out.println(userBean == factory.getBean("user"));

    }

    //集合相关表达式
    @Test
    public void test7() {

        ExpressionParser parser = new SpelExpressionParser();

        //将返回不可修改的空list
        List<Integer> result2 = parser.parseExpression("{}").getValue(List.class);
        //对于字面量列表也将返回不可修改的List
        List<Integer> result1 = parser.parseExpression("{1,2,3}").getValue(List.class);

        Assert.assertEquals(new Integer(1), result1.get(0));

        try {
            result1.set(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //对于列表中只要有一个不是字面量表达式，将只返回原始List，
        //不会进行不可修改处理
        String expression3 = "{{1+2,2+4},{3,4+4}}";
        List<List<Integer>> result3 = parser.parseExpression(expression3).getValue(List.class);
        //result3.get(0).set(0, 1);
        System.out.println(result3);

        //声明二维数组并初始化
        int[] result4 = parser.parseExpression("new int[2]{1,2}").getValue(int[].class);
        System.out.println(result4[1]);

        //定义一维数组并初始化
        int[] result5 = parser.parseExpression("new int[1]").getValue(int[].class);
        System.out.println(result5[0]);
    }

    @Test
    public void test8() {

        ExpressionParser parser = new SpelExpressionParser();

        //修改List元素值
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);   //[1, 2]

        EvaluationContext context = new StandardEvaluationContext();

        context.setVariable("collection", list);
        parser.parseExpression("#collection[1]").setValue(context, 4);
        int result = parser.parseExpression("#collection[1]").getValue(context, int.class);
        System.out.println(result);
        System.out.println(list);   //[1, 4]
    }

    @Test
    public void test9() {

        ExpressionParser parser = new SpelExpressionParser();

        //1.测试集合或数组
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("list", list);
        Collection<Integer> result = parser.parseExpression("#list.![#this+1]").getValue(context, Collection.class);
        result.forEach(System.out::println);

        //2.测试字典
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("map", map);
        List<Integer> result1 = parser.parseExpression("#map.![value+1]").getValue(context1, List.class);
        result1.forEach(System.out::println);

    }

    @Test
    public void test10() {
        ExpressionParser parser = new SpelExpressionParser();

        //1.测试集合或数组
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(1);
        list.add(4);
        list.add(5);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("list", list);
        Collection<Integer> result = parser.parseExpression("#list.?[#this>4]").getValue(context, Collection.class);
        result.forEach(System.out::println);

        //2.测试字典
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("map", map);
        Map<String, Integer> result2 = parser.parseExpression("#map.?[key!='a']").getValue(context2, Map.class);
        result2.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("------------");
        List<Integer> result3 = parser.parseExpression("#map.?[key!='a'].![value+1]").getValue(context2, List.class);
        result3.forEach(System.out::println);
    }

    @Test
    public void test11() {

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

    @Test
    public void test12() {
        SpelExpressionParser parser = new SpelExpressionParser();

        TemplateParserContext context = new TemplateParserContext("%{", "}");
        Expression expression = parser.parseExpression("订单【%{#orderL1Id}】的【%{#taskTemplateName}】环节已发生故障，请尽快处理！",context);

        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("orderL1Id", "12312313");
        evaluationContext.setVariable("taskTemplateName", "信通院");

        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(value);
    }

    @Test
    public void test13() {

    }


    //@Test
    //public void testSpELXmlConfig() {
    //
    //    ApplicationContext context = new ClassPathXmlApplicationContext("springSpEL.xml");
    //
    //    Person person = (Person) context.getBean("person");
    //
    //    System.out.println(person.getBookName());
    //
    //    System.out.println(person.getBook().getPages());
    //}

    //@Test
    //@ExtendWith(SpringExtension.class)
    //public void testSpELPropConfig() {
    //
    //    @Resource
    //    Employee employee;
    //}

}
