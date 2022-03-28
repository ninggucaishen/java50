package cc.heikafei.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Socket服务端测试
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(6666);
        boolean flag = true;
        while (flag) {

            //接收客户端请求
            System.out.println("监听客户端的数据：");
            Socket accept = socket.accept();

            InputStream inputStream = accept.getInputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            len = inputStream.read(buffer);

            String getData = new String(buffer, 0, len);
            System.out.println("从客户端监听获取的数据：" + getData);

            //业务处理
            String outPutData = getData.toUpperCase();

            //向客户端写数据
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write(outPutData.getBytes(StandardCharsets.UTF_8));

            //释放资源
            outputStream.close();
            inputStream.close();
            accept.close();
        }
        socket.close();
    }
}
