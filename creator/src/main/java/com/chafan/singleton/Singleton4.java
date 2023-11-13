package com.chafan.singleton;

/**
 * @Auther: 茶凡
 * @ClassName Singleton4
 * @date 2023/11/13 21:43
 * @Description 内部类单例
 */

// 内部类单例是单例模式的一种常用实现方式，它利用了 Java 类加载器和类的静态初始化机制来确保单例的唯一性，并且提供了良好的封装性。
public class Singleton4 {

    public Singleton4() {}

    private static class SingletonHolder{
        private static final Singleton4 Instance = new Singleton4();
    }

    // 内部类单例的主要原理是利用了 Java 的类装载机制来确保实例的唯一性。
    // 在第一次调用 getInstance 方法时，会触发内部类的装载和初始化，从而创建唯一的实例。
    // 由于每个类加载器只会加载一次类，因此只要单例类不再被卸载，那么该实例就不会被再次加载和初始化。
    public static Singleton4 getInstance() {
        return SingletonHolder.Instance;
    }

}
