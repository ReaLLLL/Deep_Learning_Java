package com.maowei.learning.thread.callback;

public class CallbackTest {
    public static void main(String[] args) {
        MyServer server = new MyServer();
        MyClient client = new MyClient(server);

        client.sendMsg("Hello World!");
    }
}
