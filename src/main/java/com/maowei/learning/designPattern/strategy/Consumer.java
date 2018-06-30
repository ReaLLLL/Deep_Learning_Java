package com.maowei.learning.designPattern.strategy;

import com.maowei.learning.designPattern.strategy.impl.OrdinaryStrategy;

import java.math.BigDecimal;

public class Consumer {
    //单次消费金额
    private BigDecimal amount;
    //累计消费金额
    private BigDecimal totalAmount;
    //优惠策略
    private DiscountStrategy strategy;

    public Consumer() {
        this.amount = BigDecimal.ZERO;
        this.totalAmount = BigDecimal.ZERO;
        this.strategy = new OrdinaryStrategy();
    }

    public void consume(BigDecimal amount){
        this.amount = amount;
//        if(this.totalAmount.compareTo(new BigDecimal(3000)) < 0){
//            //累计消费金额小于3000元，适用普通优惠策略
//            this.strategy = new OrdinaryStrategy();
//        }else if(this.totalAmount.compareTo(new BigDecimal(6000)) < 0){
//            //累计消费金额小于6000元，适用普通优惠策略
//            this.strategy = new MemberStrategy();
//        }else {
//            //适用高级优惠策略
//            this.strategy = new SeniorStrategy();
//        }
    }

    public BigDecimal getAmount() {
        this.totalAmount = this.totalAmount.add(this.amount);
        return this.strategy.getDiscountAmount(this.amount);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
}
