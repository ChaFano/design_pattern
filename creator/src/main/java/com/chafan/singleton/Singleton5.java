package com.chafan.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: 茶凡
 * @ClassName Singleton5
 * @date 2023/11/13 21:52
 * @Description 枚举单例
 */

// 具体来说，枚举单例的工作原理是：当枚举类被加载时，JVM 会自动创建它的实例，而且在枚举类中，每个枚举值都是唯一的。
public enum Singleton5 {
    INSTANCE;

    public void method() {}
}


// 应用例子
enum ServiceRegistry {
    INSTANCE;

    private Map<String, ServiceProvider> serviceMap = new ConcurrentHashMap<>();

    public void registerServiceProvider(ServiceProvider provider) {
        this.serviceMap.put(provider.getName(), provider);
    }

    public ServiceProvider getServiceProvider(String serviceName) {
        return this.serviceMap.get(serviceName);
    }
}

interface ServiceProvider {
    String getName();
}
