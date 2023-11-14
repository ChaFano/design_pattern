package com.chafan.abstruct;

/**
 * @Auther: 茶凡
 * @ClassName AbstractCar
 * @date 2023/11/14 23:36
 * @Description 抽象工厂类
 */
public abstract class AbstractCar {

    protected CarPartFactory factory;

    public AbstractCar(CarPartFactory factory) {
        this.factory = factory;
    }

    public void run() {
        Engine engine = factory.createEngine();
        engine.startEngine();

        Wheel wheel = factory.createWheel();
        wheel.spinWheel();
    }
}


class LuxuryCar extends AbstractCar {
    public LuxuryCar() {
        super(new LuxuryCarPartFactory());
    }
}

class EconomyCar extends AbstractCar {
    public EconomyCar() {
        super(new EconomyCarPartFactory());
    }
}

class LuxuryCarPartFactory implements CarPartFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Wheel createWheel() {
        return new LuxuryWheel();
    }
}

class EconomyCarPartFactory implements CarPartFactory {
    @Override
    public Engine createEngine() {
        return new EconomyEngine();
    }

    @Override
    public Wheel createWheel() {
        return new EconomyWheel();
    }
}