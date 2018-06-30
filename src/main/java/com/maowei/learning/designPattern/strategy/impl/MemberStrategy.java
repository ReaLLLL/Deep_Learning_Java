package com.maowei.learning.designPattern.strategy.impl;

import com.maowei.learning.designPattern.strategy.DiscountStrategy;
import com.maowei.learning.designPattern.strategy.PriceRegion;

import java.math.BigDecimal;

@PriceRegion(min = 3000,max = 6000)
public class MemberStrategy implements DiscountStrategy{
    public BigDecimal getDiscountAmount(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.95"));
    }
}
