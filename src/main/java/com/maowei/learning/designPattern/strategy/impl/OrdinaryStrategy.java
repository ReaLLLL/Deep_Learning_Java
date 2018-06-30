package com.maowei.learning.designPattern.strategy.impl;

import com.maowei.learning.designPattern.strategy.DiscountStrategy;
import com.maowei.learning.designPattern.strategy.PriceRegion;

import java.math.BigDecimal;

@PriceRegion(min = 0,max = 3000)
public class OrdinaryStrategy implements DiscountStrategy {
    public BigDecimal getDiscountAmount(BigDecimal amount) {
        return amount;
    }
}