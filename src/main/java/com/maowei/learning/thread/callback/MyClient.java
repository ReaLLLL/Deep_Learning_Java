package com.maowei.learning.thread.callback;

public class MyClient implements MyCallback{
    private MyServer server;

    public MyClient(MyServer server) {
        this.server = server;
    }

    public void sendMsg(final String msg){
        System.out.println("客户端：发送的消息为：" + msg);

        new Thread(new Runnable() {
            public void run() {
                server.getClientMsg(MyClient.this, msg);
            }
        }).start();

        System.out.println("客户端：异步发送成功");
    }

    public void process(String str) {
        System.out.println("客户端：服务端回调状态为：" + str);
    }
}
