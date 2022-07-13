package cc.heikafei.nettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MyServerHandler
 * @Description 服务端处理类
 * @Auther Ning
 * @Date 2022/7/13 16:02
 * @Version 1.0
 */

@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发来的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到客户端" + ctx.channel().remoteAddress() + "发送消息" + byteBuf.toString(CharsetUtil.UTF_8));
    }*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取到线程池eventLoop，添加线程，执行
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("延迟5秒");
                    //长时间操作，不至于长时间的业务操作导致Handler阻塞
                    Thread.sleep(5000);
                    try {
                        int a = 10 / 0;
                    } catch (Exception e) {
                        log.error("error:" + e.getMessage());
                    }
                    System.out.println("长时间的业务处理");
                } catch (InterruptedException e) {
                    log.error("错误原因：" + e.getMessage());
                }
            }
        });
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //发送消息给客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已收到消息，并发送你一个 ？", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //发生异常，关闭通道
        ctx.close();
    }

}
