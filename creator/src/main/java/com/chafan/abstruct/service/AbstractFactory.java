package com.chafan.abstruct.service;


/**
 * 新添加产品 需要 修改 抽象类 违背 开闭原则
 */
public interface AbstractFactory {

	HtmlDocument createHtml(String md);

	WordDocument createWord(String md);

}
