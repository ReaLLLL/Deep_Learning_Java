package com.maowei.learning.thread.callback;

public class MyServer {
    public void getClientMsg(MyCallback callback, String msg){
        System.out.println("服务端：收到客户端消息："+msg);

        try {
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("服务端：消息处理成功，返回状态 200");

        callback.process("200");
    }
}
