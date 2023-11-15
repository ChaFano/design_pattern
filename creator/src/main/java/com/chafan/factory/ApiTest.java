package com.chafan.factory;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/13 21:08
 * @Description 工厂模式的测试
 */

// 我们创建了一个ShapeFactory接口和一个其实现类ShapeFactoryImpl。在ShapeFactoryImpl中，我们根据传入的字符串类型返回相应的形状对象。

// 然后我们在主函数中通过工厂类来创建形状对象。这样当我们想添加更多形状时，我们只需要修改工厂类，而不需要修改客户端代码。

// 总结一下，工厂模式的主要优点是可以将对象的创建和使用解耦，使得我们可以更加灵活地控制对象的实例化过程。

// 同时，由于具体的实现细节都被隐藏在了工厂类里面，所以也可以提高代码的可读性和可维护性。
public class ApiTest {

    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactoryImpl();
        Shape shape1 = factory.getShape("CIRCLE");
        Shape shape2 = factory.getShape("RECTANGLE");
        shape1.draw();
        shape2.draw();
    }


}


abstract class Shape {

    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// 如果有其他产品添加进来 就需要在工厂内添加 违背开闭原则
interface ShapeFactory {
    Shape getShape(String shapeType);
}

class ShapeFactoryImpl implements ShapeFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        } else if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}