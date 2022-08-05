package cc.heikafei.bean;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Auther Ning
 * @Date 2022/8/4 15:14
 * @Version 1.0
 */
public class SerializableTest {

    /*@Test
    public void testVersion() throws IOException, ClassNotFoundException {

        File file = new File("person.txt");

        //序列化：对象序列化的最主要的用处就是在传递和保存对象的时候，保证对象的完整性和可传递性。
        //序列化是把对象转换成有序字节流，以便在网络上传输或者保存在本地文件中。
        //核心作用是对象状态的保存与重建。
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("ning",23,"Nanjing","3212133@qq.com");
        outputStream.writeObject(person);
        outputStream.close();

        //反序列化：客户端从文件中或网络上获得序列化后的对象字节流，
        //根据字节流中所保存的对象状态及描述信息，通过反序列化重建对象。
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = inputStream.readObject();
        inputStream.close();

        Map map = new HashMap();

        System.out.println(newPerson);
    }

    @Test
    public void testversion1LWithExtraEmail() throws Exception {
        File file = new File("person.txt");
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }*/

    @Test
    public void testSerialize() throws IOException {

        Person person = new Person("daxiang",23,"Nanjing","3212133@qq.com");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
        outputStream.writeObject(person);
        outputStream.close();

        System.out.println("序列化成功！已经生成person.txt文件");
        System.out.println("==================================");
    }

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("person.txt")));
        Person person = (Person) inputStream.readObject();
        inputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(person);
    }

}
