package com.maowei.learning.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private static final int port = 10000;

    public static void main(String[] args) {
        try {
            //创建选择器
            Selector selector = Selector.open();
            //打开通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            //开启非阻塞模式
            channel.configureBlocking(false);

            channel.socket().bind(new InetSocketAddress(port), 1024);

            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                selector.select(500);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    try {
                        handInput(selector, key);
                    }catch(Exception e){
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected static void handInput(Selector selector, SelectionKey key) throws IOException{
        if(key.isValid()){
            if(key.isAcceptable()) {
                //处理新的请求 三次握手 建立连接
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
        }

        if(key.isReadable()){
            SocketChannel sc = (SocketChannel) key.channel();
            //创建ByteBuffer，并开辟一个1M的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //读取请求码流，返回读取到的字节数
            int readBytes = sc.read(buffer);
            if(readBytes>0){
                //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                buffer.flip();
                //根据缓冲区可读字节数创建字节数组
                byte[] bytes = new byte[buffer.remaining()];
                //将缓冲区可读字节数组复制到新建的数组中
                buffer.get(bytes);
                String expression = new String(bytes,"UTF-8");
                System.out.println("服务器收到消息：" + expression);

                //发送应答消息
                doWrite(sc,expression);
            }
            //没有读取到字节 忽略
//              else if(readBytes==0);
            //链路已经关闭，释放资源
            else if(readBytes<0){
                key.cancel();
                sc.close();
            }
        }
    }

    protected static void doWrite(SocketChannel channel,String response) throws IOException{
        //将消息编码为字节数组
        byte[] bytes = response.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        channel.write(writeBuffer);
        //****此处不含处理“写半包”的代码
    }
}
