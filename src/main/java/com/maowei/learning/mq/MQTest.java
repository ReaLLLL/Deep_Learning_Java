package com.maowei.learning.mq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class MQTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-rabbitmq.xml");

        MqProducerImpl producer = (MqProducerImpl) ctx.getBean("mqProducer");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", "Hello RabbitMQ!");

        producer.sendDataToQueue("test_mq_exchange","test_mq_patt", map);
    }
}
