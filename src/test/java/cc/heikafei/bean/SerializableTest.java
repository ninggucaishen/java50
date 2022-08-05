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

        //���л����������л�������Ҫ���ô������ڴ��ݺͱ�������ʱ�򣬱�֤����������ԺͿɴ����ԡ�
        //���л��ǰѶ���ת���������ֽ������Ա��������ϴ�����߱����ڱ����ļ��С�
        //���������Ƕ���״̬�ı������ؽ���
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("ning",23,"Nanjing","3212133@qq.com");
        outputStream.writeObject(person);
        outputStream.close();

        //�����л����ͻ��˴��ļ��л������ϻ�����л���Ķ����ֽ�����
        //�����ֽ�����������Ķ���״̬��������Ϣ��ͨ�������л��ؽ�����
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

        System.out.println("���л��ɹ����Ѿ�����person.txt�ļ�");
        System.out.println("==================================");
    }

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("person.txt")));
        Person person = (Person) inputStream.readObject();
        inputStream.close();

        System.out.println("�����л����Ϊ��");
        System.out.println(person);
    }

}
