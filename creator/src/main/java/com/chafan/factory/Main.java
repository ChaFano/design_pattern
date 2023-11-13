package com.chafan.factory;

/**
 * @Auther: 茶凡
 * @ClassName Main
 * @date 2023/11/13 21:13
 * @Description 反例子
 */

//  在这个例子中，我们定义了一个Shape抽象类和两个具体形状Circle和Rectangle。
//  在主函数中，我们直接创建了Circle和Rectangle的实例并调用它们的方法。
//  这很简单，但是如果我们想添加更多的形状，我们需要不断地修改主函数，这显然不符合开闭原则。
public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        circle.draw();
        rectangle.draw();
    }

}

