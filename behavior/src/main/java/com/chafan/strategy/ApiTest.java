package com.chafan.strategy;

import java.math.BigDecimal;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/21 16:00
 * @Description 策略模式测试
 */
public class ApiTest {


    public static void main(String[] args) {
        DiscountContext ctx = new DiscountContext();
        // 默认使用普通会员折扣:
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);

        // 使用满减折扣:
        ctx.setStrategy(new OverDiscountStrategy());
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);

        // 使用Prime会员折扣:
        ctx.setStrategy(new PrimeDiscountStrategy());
        BigDecimal pay3 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay3);
    }


}
