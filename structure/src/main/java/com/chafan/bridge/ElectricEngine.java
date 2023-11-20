package com.chafan.bridge;

/**
 * 电车引擎
 */
public class ElectricEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Start 电车 Engine...");
	}
}
