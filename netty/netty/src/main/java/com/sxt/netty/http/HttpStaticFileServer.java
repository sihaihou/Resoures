package com.sxt.netty.http;  
  
import io.netty.bootstrap.ServerBootstrap;  
import io.netty.channel.EventLoopGroup;  
import io.netty.channel.nio.NioEventLoopGroup;  
import io.netty.channel.socket.nio.NioServerSocketChannel;  
  
/** 
 * http协议文件传输 
 * @author Qixuan.Chen 
 * 创建时间：2015年5月4日 
 */  
public class HttpStaticFileServer {  
  
      
    private final int port;//端口  
  
    public HttpStaticFileServer(int port) {  
        this.port = port;  
    }  
  
    public void run() throws Exception {  
        EventLoopGroup bossGroup = new NioEventLoopGroup();//线程一 //这个是用于serversocketchannel的event  
        EventLoopGroup workerGroup = new NioEventLoopGroup();//线程二//这个是用于处理accept到的channel  
        try {  
            ServerBootstrap b = new ServerBootstrap();  
            b.group(bossGroup, workerGroup)  
             .channel(NioServerSocketChannel.class)  
             .childHandler(new HttpStaticFileServerInitializer());  
  
            b.bind(port).sync().channel().closeFuture().sync();  
        } finally {  
            bossGroup.shutdownGracefully();  
            workerGroup.shutdownGracefully();  
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        int port = 8089;  
        if (args.length > 0) {  
            port = Integer.parseInt(args[0]);  
        } else {  
            port = 8089;  
        }  
        new HttpStaticFileServer(port).run();//启动服务  
    }  
}  