package com.chafan.singleton;

/**
 * @Auther: 茶凡
 * @ClassName Singleton7
 * @date 2023/11/13 21:57
 * @Description 使用 ThreadLocal 创建单例
 */
// 面试的时候不建议 答
public class Singleton7 {

    // 在单例模式中，可以使用 ThreadLocal 来确保单例的唯一性。首先，将单例实例保存在 ThreadLocal 中，然后在每个线程中获取这个实例。
    // 由于每个线程都有自己独立的 ThreadLocal 实例，所以即使多个线程并发地调用 getInstance 方法，也会得到同一个单例实例。
    private static ThreadLocal<Singleton7> instanceHolder = new ThreadLocal<>();

    private Singleton7() {}

    // 使用 ThreadLocal 创建单例的优势在于，它既满足了单例的唯一性，又减少了同步的开销，因此比较适合于高性能场景。
    // 当然，ThreadLocal 也有一些局限性，比如它仅适用于线程相关的数据，而且可能会占用较多的内存。因此，在使用 ThreadLocal 时，需要权衡性能和内存消耗的问题。
    public static Singleton7 getInstance() {

        Singleton7 instance = instanceHolder.get();

        if (instance == null) {

            instance = new Singleton7();

            instanceHolder.set(instance);

        }
        return instance;
    }

}
