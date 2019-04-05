package com.sxt.netty.http;

import io.netty.channel.ChannelInitializer;  
import io.netty.channel.ChannelPipeline;  
import io.netty.channel.socket.SocketChannel;  
import io.netty.handler.codec.http.HttpObjectAggregator;  
import io.netty.handler.codec.http.HttpRequestDecoder;  
import io.netty.handler.codec.http.HttpResponseEncoder;  
import io.netty.handler.stream.ChunkedWriteHandler;  
  
public class HttpStaticFileServerInitializer extends ChannelInitializer<SocketChannel> {  
    @Override  
    public void initChannel(SocketChannel ch) throws Exception {  
        // Create a default pipeline implementation.  
        ChannelPipeline pipeline = ch.pipeline();  
  
        // Uncomment the following line if you want HTTPS  
        //SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();  
        //engine.setUseClientMode(false);  
        //pipeline.addLast("ssl", new SslHandler(engine));  
       /** 
        *   （1）ReadTimeoutHandler，用于控制读取数据的时候的超时，10表示如果10秒钟都没有数据读取了，那么就引发超时，然后关闭当前的channel 
 
            （2）WriteTimeoutHandler，用于控制数据输出的时候的超时，构造参数1表示如果持续1秒钟都没有数据写了，那么就超时。 
             
            （3）HttpRequestrianDecoder，这个handler用于从读取的数据中将http报文信息解析出来，无非就是什么requestline，header，body什么的。。。 
             
            （4）然后HttpObjectAggregator则是用于将上卖解析出来的http报文的数据组装成为封装好的httprequest对象。。 
             
            （5）HttpresponseEncoder，用于将用户返回的httpresponse编码成为http报文格式的数据 
             
            （6）HttpHandler，自定义的handler，用于处理接收到的http请求。 
        */  
          
        pipeline.addLast("decoder", new HttpRequestDecoder());// http-request解码器,http服务器端对request解码  
        pipeline.addLast("aggregator", new HttpObjectAggregator(65536));//对传输文件大少进行限制  
        pipeline.addLast("encoder", new HttpResponseEncoder());//http-response解码器,http服务器端对response编码  
        // 向客户端发送数据的一个Handler
        pipeline.addLast("chunkedWriter", new ChunkedWriteHandler());  
  
        pipeline.addLast("handler", new HttpStaticFileServerHandler(true)); // Specify false if SSL.(如果是ssl,就指定为false)  
    }  
}  