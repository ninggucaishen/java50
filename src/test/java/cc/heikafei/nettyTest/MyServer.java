package cc.heikafei.nettyTest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName MyServer
 * @Description 服务端启动类
 * @Auther Ning
 * @Date 2022/7/13 15:52
 * @Version 1.0
 */
public class MyServer {

    public static void main(String[] args) throws InterruptedException {

        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务端的启动对象，设置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置两个线程组 bossGroup workerGroup
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)      //设置服务端通道实现类型
                    .option(ChannelOption.SO_BACKLOG, 128)      //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)      //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {     //使用匿名内部类的形式初始化通道对象

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {

                            //给pipeline管道设置处理器
                            socketChannel.pipeline().addLast(new MyServerHandler());
                        }
                    });
            System.out.println("服务端已准备就绪....");

            //绑定端口号,启动服务端
            ChannelFuture channelFuture = bootstrap.bind(6666).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
