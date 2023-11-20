package com.chafan.decorator;




public class ItalicDecorator extends NodeDecorator {

	public ItalicDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<i>" + target.getText() + "</i>";
	}
}
