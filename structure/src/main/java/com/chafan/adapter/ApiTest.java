package com.chafan.adapter;

import java.util.concurrent.Callable;



/**
实现目标接口，这里是Runnable；

 1、内部持有一个待转换接口的引用，这里是通过字段持有Callable接口；

 2、在目标接口的实现方法内部，调用待转换接口的方法。

 3、这样一来，Thread就可以接收这个RunnableAdapter，因为它实现了Runnable接口。
	Thread作为调用方，它会调用RunnableAdapter的run()方法，在这个run()方法内部，
	又调用了Callable的call()方法，相当于Thread通过一层转换，间接调用了Callable的call()方法。
*/

public class ApiTest {

	public static void main(String[] args) throws Exception {
		Callable<Long> callable = new Task(123450000L);
		Thread thread = new Thread(new RunnableAdapter(callable));
		thread.start();
		thread.join();
	}
}
