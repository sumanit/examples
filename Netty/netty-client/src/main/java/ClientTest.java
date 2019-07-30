import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 苏曼 on 2019/7/3.
 */
public class ClientTest {
    public static void main(String[] args)  {

        Bootstrap client = new Bootstrap();

        //第1步 定义线程组，处理读写和链接事件，没有了accept事件
        EventLoopGroup group = new NioEventLoopGroup();
        client.group(group );

        //第2步 绑定客户端通道
        client.channel(NioSocketChannel.class);

        //第3步 给NIoSocketChannel初始化handler， 处理读写事件
        client.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                //字符串编码器，一定要加在SimpleClientHandler 的上面
                ch.pipeline().addLast(new StringEncoder());
                ch.pipeline().addLast(new DelimiterBasedFrameDecoder(
                        Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                //找到他的管道 增加他的handler
                ch.pipeline().addLast(new SimpleClientHandler());
            }
        });

        //连接服务器
        AtomicInteger num = new AtomicInteger();

        for (int i = 0; i <10000 ; i++) {
            final int index =i;

                new Thread(){
                    @Override
                    public void run() {
                        try {
                        ChannelFuture future = client.connect("192.168.9.64", 10728).sync();



                        //当通道关闭了，就继续往下走

                            ChannelFuture sync = future.channel().closeFuture().sync();
                            System.out.println(String.valueOf(sync));
                        } catch (Exception e) {
                            num.addAndGet(-1);
                            System.out.println(index);
                            e.printStackTrace();
                        }
                    }
                }.start();


        }
        while(true) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num.get());
        }



    }
}
