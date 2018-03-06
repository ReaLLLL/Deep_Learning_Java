package com.maowei.learning.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 10000;

    public static void main(String[] args){

        ServerSocket server = null;

        try{
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);

            while (true){
                Socket socket = server.accept();

                new Thread(new ServerHandler(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(server != null){
                System.out.println("服务器已关闭。");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
