package cc.heikafei.nettyTest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName MyClient
 * @Description 客户端启动类
 * @Auther Ning
 * @Date 2022/7/13 17:15
 * @Version 1.0
 */
public class MyClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            //创建bootstrap对象，配置参数
            Bootstrap bootStrap = new Bootstrap();
            //设置线程组
            bootStrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //添加客户端通道的处理器
                            socketChannel.pipeline().addLast(new MyClientHandler());
                        }
                    });
            System.out.println("客户端准备就绪，随时起飞！");

            //连接服务器
            ChannelFuture channelFuture = bootStrap.connect("127.0.0.1", 6666).sync();
            //对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();

        } finally {
            //关闭线程组
            eventExecutors.shutdownGracefully();
        }
    }
}
