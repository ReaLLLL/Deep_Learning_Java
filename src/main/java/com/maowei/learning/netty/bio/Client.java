package com.maowei.learning.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static int DEFAULT_SERVER_PORT = 10000;
    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket(DEFAULT_SERVER_IP, DEFAULT_SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

            out.println("echo");
            System.out.println(in.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //一下必要的清理工作
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
