package com.chafan.chain;

import java.math.BigDecimal;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/21 10:23
 * @Description 责任链模式
 */
public class ApiTest {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));
    }
}
