package cc.heikafei.test;

/**
 * 静态接口测试
 * 接口默认方法测试
 */
public class StaticInterfaceTest {
    public static void main(String[] args) {

//        StaticInterfaceTest.method();

        //测试默认接口
        TestObject object = new TestObject();
        object.sameMethod();        //Invoke Object method!

    }

    private static void method() {
        System.out.println("这是Java8接口中的静态方法！");
    }

    //测试接口一
    private interface TestInterface1 {
        default void sameMethod() {
            System.out.println("Invoke TestInterface1 method!");
        }
    }

    //测试接口二
    private interface TestInterface2 {
        default void sameMethod() {
            System.out.println("Invoke TestInterface2 method!");
        }
    }

    //继承两个接口的类
    private static class TestObject implements TestInterface1, TestInterface2 {
        @Override
        public void sameMethod() {
            System.out.println("Invoke Object method!");
        }
    }

}
