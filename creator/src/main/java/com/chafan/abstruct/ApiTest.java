package com.chafan.abstruct;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/14 23:25
 * @Description 抽象工厂测试
 */
public class ApiTest {

    public static void main(String[] args) {
        LuxuryCar car1 = new LuxuryCar();
        car1.run();

        EconomyCar car2 = new EconomyCar();
        car2.run();
    }

}
