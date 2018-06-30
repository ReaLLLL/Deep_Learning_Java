package com.maowei.learning.designPattern.strategy;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.consume(new BigDecimal(2000));
        System.out.println("应付金额："+consumer.getAmount().setScale(1, BigDecimal.ROUND_UP).doubleValue());
        consumer.consume(new BigDecimal(2000));
        System.out.println("应付金额："+consumer.getAmount().setScale(1,BigDecimal.ROUND_UP).doubleValue());
        consumer.consume(new BigDecimal(2000));
        System.out.println("应付金额："+consumer.getAmount().setScale(1,BigDecimal.ROUND_UP).doubleValue());
        consumer.consume(new BigDecimal(2000));
        System.out.println("应付金额："+consumer.getAmount().setScale(1,BigDecimal.ROUND_UP).doubleValue());

    }
}
