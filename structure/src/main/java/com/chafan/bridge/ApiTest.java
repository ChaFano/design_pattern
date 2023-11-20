package com.chafan.bridge;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/20 10:43
 * @Description 桥接模式 测试
 */
public class ApiTest {

    public static void main(String[] args) {
        RefinedCar car1 = new BossCar(new HybridEngine());
        car1.drive();
        // 即不要过度使用继承，而是优先拆分某些部件，使用组合的方式来扩展功能。减少子类的继承爆炸
        RefinedCar car2 = new TinyCar(new ElectricEngine());
        car2.drive();
        RefinedCar car3 = new TinyCar(new FuelEngine());
        car3.drive();
        RefinedCar car4 = new TinyCar(new HybridEngine());
        car4.drive();
    }
}
