package com.chafan.singleton;

/**
 * @Auther: 茶凡
 * @ClassName Singleton
 * @date 2023/11/13 21:33
 * @Description 饿汉式单例
 */

// 饿汉式（静态常量）(推荐使用)
public class Singleton {

    private  static final Singleton INSTANCE = new Singleton();

    // 私有的构造器 防止外部入侵
    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }

}

// 饿汉式（静态代码块）(推荐使用)
class Singleton1{
    //构造方法私有化，外部不能new
    private Singleton1(){}

    private static Singleton1 instance;

    static { //在静态代码块中，创建单例对象
        instance = new Singleton1();
    }
    public static Singleton1 getInstance(){
        return instance;
    }
}
