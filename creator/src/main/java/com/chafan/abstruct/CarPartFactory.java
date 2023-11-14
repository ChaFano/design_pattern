package com.chafan.abstruct;




/**
 * @Auther: 茶凡
 * @ClassName CarPartFactory
 * @date 2023/11/14 23:32
 * @Description 汽车组装工厂
 */
public interface CarPartFactory {

    Engine createEngine();
    Wheel createWheel();

}


interface Engine {
    void startEngine();
}


class LuxuryEngine implements Engine {

    @Override
    public void startEngine() {
        System.out.println("Starting luxury engine...");
    }
}

class EconomyEngine implements Engine {

    @Override
    public void startEngine() {
        System.out.println("Starting economy engine...");
    }
}

interface Wheel {
    void spinWheel();
}

class LuxuryWheel implements Wheel {

    @Override
    public void spinWheel() {
        System.out.println("Spinning luxury wheel...");
    }
}

class EconomyWheel implements Wheel {

    @Override
    public void spinWheel() {
        System.out.println("Spinning economy wheel...");
    }
}