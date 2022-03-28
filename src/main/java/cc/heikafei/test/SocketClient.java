package cc.heikafei.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Socket客户端测试
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {

        //获取用户输入的数据
        System.out.print("请输入数据：");
        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();

        //开启一个Socket端口
        Socket socket = new Socket("127.0.0.1", 6666);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(inputData.getBytes(StandardCharsets.UTF_8));

        //获取服务端传回的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        len = inputStream.read(buffer);
        String getData = new String(buffer, 0, len);
        System.out.println("从服务端传回的数据：" + getData);

        //关闭
        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
