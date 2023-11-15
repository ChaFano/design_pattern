package com.chafan.abstruct.good;



import com.chafan.abstruct.service.AbstractFactory;
import com.chafan.abstruct.service.HtmlDocument;
import com.chafan.abstruct.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
