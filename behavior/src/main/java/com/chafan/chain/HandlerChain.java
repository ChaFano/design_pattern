package com.chafan.chain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 责任链模式 将所有的请求处理装入到 List<Handler> 集合中 遍历集合 将对应的请求 进行验证 匹配其责任
 *
 *
 */
public class HandlerChain {

	private List<Handler> handlers = new ArrayList<>();

	public void addHandler(Handler handler) {
		this.handlers.add(handler);
	}

	public boolean process(Request request) {
		for (Handler handler : handlers) {
			Boolean r = handler.process(request);
			if (r != null) {
				System.out.println(
						request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
				return r;
			}
		}
		throw new RuntimeException("Could not handle request: " + request);
	}
}
