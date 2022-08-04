package cc.heikafei.bean;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 15:14
 * @Version 1.0
 */
public class SerializableTest {

    @Test
    public void testVersion() throws IOException, ClassNotFoundException {

        File file = new File("person.out");

        //序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("ning",23,"Nanjing","3212133@qq.com");
        outputStream.writeObject(person);
        outputStream.close();

        //反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = inputStream.readObject();
        inputStream.close();

        System.out.println(newPerson);
    }

    @Test
    public void testversion1LWithExtraEmail() throws Exception {
        File file = new File("person.out");
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }
}
