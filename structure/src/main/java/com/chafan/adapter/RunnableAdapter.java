package com.chafan.adapter;

import java.util.concurrent.Callable;


/**
 *
 *  Thread 需要的是 Runnable  任务使用的是 Callable
 *
 *  使用 RunnableAdapter 做为适配器将其转换一下
 *
 *  使得 Thread 调用 RunnableAdapter 实际上调用的 Callable 的任务
 *
 */

public class RunnableAdapter implements Runnable {

	// 引用待转换接口:
	private Callable<?> callable;

	public RunnableAdapter(Callable<?> callable) {
		this.callable = callable;
	}

	// 实现指定接口:
	@Override
	public void run() {
		// 将指定接口调用委托给转换接口调用:
		try {
			callable.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
