package com.chafan.abstruct.factory;


import com.chafan.abstruct.service.AbstractFactory;
import com.chafan.abstruct.service.HtmlDocument;
import com.chafan.abstruct.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
