package com.maowei.learning.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client {
    private static int DEFAULT_SERVER_PORT = 10000;
    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            //创建选择器
            Selector selector = Selector.open();
            //打开通道
            SocketChannel sc = SocketChannel.open();

            sc.configureBlocking(false);

            if(sc.connect(new InetSocketAddress(DEFAULT_SERVER_IP, DEFAULT_SERVER_PORT)))
                ;
            else
                sc.register(selector, SelectionKey.OP_CONNECT);

            while (true){
                try{
                    //无论是否有读写事件发生，selector每隔500ms被唤醒一次
                    selector.select(500);
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    SelectionKey key = null;
                    while(it.hasNext()){
                        key = it.next();
                        it.remove();
                        try{
                            handleInput(key);
                        }catch(Exception e){
                            if(key != null){
                                key.cancel();
                                if(key.channel() != null){
                                    key.channel().close();
                                }
                            }
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

                sc.register(selector, SelectionKey.OP_READ);

                byte[] bytes = "echo".getBytes();
                //根据数组容量创建ByteBuffer
                ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                //将字节数组复制到缓冲区
                writeBuffer.put(bytes);
                //flip操作
                writeBuffer.flip();
                //发送缓冲区的字节数组
                sc.write(writeBuffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    protected static void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if(key.isConnectable()){
                if(sc.finishConnect())
                    ;
                else
                    System.exit(1);
            }
            //读消息
            if(key.isReadable()){
                //创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取到的字节数
                int readBytes = sc.read(buffer);
                //读取到字节，对字节进行编解码
                if(readBytes>0){
                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    buffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String result = new String(bytes,"UTF-8");
                    System.out.println("客户端收到消息：" + result);
                }
                else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }
}
