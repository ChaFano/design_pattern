package com.chafan.abstruct.service;

import java.io.IOException;
import java.nio.file.Path;

/**
 *  新添加一个接口 不一定需要全部实现 遵守了接口隔离原则
 */
public interface HtmlDocument {

	String toHtml();

	void save(Path path) throws IOException;
}
