package com.chafan.bridge;


/**
 * 抽象 汽车类 依赖于引擎 Engine 接口
 */
public abstract class Car {

	protected Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public abstract void drive();
}
