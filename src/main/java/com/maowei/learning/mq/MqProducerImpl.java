package com.maowei.learning.mq;

import org.springframework.amqp.core.AmqpTemplate;

public class MqProducerImpl{

    private AmqpTemplate amqpTemplate;

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendDataToQueue(String exchageKey, String queueKey, Object object){
        try {
            this.amqpTemplate.convertAndSend(exchageKey, queueKey, object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
