package com.chafan.strategy;

import java.math.BigDecimal;

public interface DiscountStrategy {

	BigDecimal getDiscount(BigDecimal total);

}
