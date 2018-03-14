package com.maowei.learning.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MqConsumerImpl implements MessageListener{
    public void onMessage(Message message) {
        try {
            System.out.println(message.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
