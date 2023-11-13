package com.chafan.singleton;

/**
 * @Auther: 茶凡
 * @ClassName Singleton2
 * @date 2023/11/13 21:34
 * @Description 懒汉式单例
 */

// 懒汉式(线程安全，同步方法)
public class Singleton2 {

    private static Singleton2 instance;

    public Singleton2() {}

    // 如果不使用同步机制（即没有加锁），那么可能会出现多个线程同时进入 getInstance 方法，从而导致多个实例的创建。
    // 这是因为 new Singleton() 这个操作不是原子性的，它可以被编译器拆分成三步：分配内存空间、初始化成员变量、设置引用指向刚分配的空间。
    // 如果没有加锁，那么在多个线程同时执行 getInstance 方法时，可能有两个线程同时完成第一步，然后再分别执行第二步和第三步，从而导致两个实例的创建。
    // 为了防止这种情况的发生，通常会在 getInstance 方法上加上 synchronized 关键字，以确保只有一个线程能够执行这个方法，从而保证只会创建一个实例。
    public synchronized static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}


//使用静态工厂方法单例( 懒汉式 线程不安全)
class Singleton2_1 {

    private static Singleton2_1 instance;

    private Singleton2_1() {}

    // 静态工厂方法单例可以做到线程安全，但需要额外的同步机制来保证线程安全性。
    // 需要像 双重检查锁定机制
    public static Singleton2_1 getInstance() {
        if (instance == null) {
            instance = new Singleton2_1();
        }
        return instance;
    }

}

// 双重检查锁定单例 (线程安全)
class Singleton2_2{

    // 使用 volatile 保证 单例在多线中的可见性
    private volatile static Singleton2_2 instance;

    public Singleton2_2() {}

    public static Singleton2_2 getInstance() {

        if (instance == null){

            // 加锁确保多线程下只有一个实例被创建
            synchronized(Singleton2_2.class){
                if(instance == null){
                    instance = new Singleton2_2();
                }
            }
        }
        return instance;
    }

}

class Singleton2_3{
    private static Singleton2_3 singleton;

    private Singleton2_3(){};

    public static Singleton2_3 getInstance(){
        if(singleton == null){
            synchronized (Singleton2_3.class){
                singleton = new Singleton2_3();
            }
        }
        return singleton;
    }
}
