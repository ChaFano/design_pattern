package com.chafan.bridge;


public abstract class RefinedCar extends Car {

	public RefinedCar(Engine engine) {
		// 调用父类的构造函数
		super(engine);
	}

	public void drive() {
		// 父类的 engine.start()
		this.engine.start();
		System.out.println("Drive " + getBrand() + " car...");
	}

	public abstract String getBrand();
}
