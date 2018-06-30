package com.maowei.learning.designPattern.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal getDiscountAmount(BigDecimal amount);
}
