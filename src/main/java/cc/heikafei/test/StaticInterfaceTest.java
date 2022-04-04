package cc.heikafei.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 静态接口测试
 * 接口默认方法测试
 * 方法引用测试
 */
public class StaticInterfaceTest {
    public static void main(String[] args) {

        StaticInterfaceTest.method();

        //测试默认接口
        TestObject object = new TestObject();
        object.sameMethod();        //Invoke Object method!

        testMethod();

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

    //测试JavaBean
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @ToString
    private static class Person {
        String name;
        LocalDate birthday;

        public Person(String name, LocalDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public static int compareByAge(Person a, Person b) {
            return a.birthday.compareTo(b.birthday);
        }

    }

    private static void testMethod() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016, 9, 1)),
                new Person("001", LocalDate.of(2016, 2, 1)),
                new Person("002", LocalDate.of(2016, 3, 1)),
                new Person("004", LocalDate.of(2016, 12, 1))
        };

        //使用匿名类
        Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.birthday);
            }
        });

        //使用Lambda表达式
        /*Arrays.sort(pArr, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.birthday);
        });*/

        //使用方法引用，引用的是类的静态方法
        Arrays.sort(pArr, Person::compareByAge);

    }

}
