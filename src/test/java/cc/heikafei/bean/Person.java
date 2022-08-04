package cc.heikafei.bean;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 15:11
 * @Version 1.0
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 2L;

    private String name;
    private Integer age;
    private String address;
    private String email;

    public Person() {
    }

    public Person(String name, Integer age, String address, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
