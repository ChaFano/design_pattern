package com.chafan.observer;

public interface ProductObserver {

	void onPublished(Product product);

	void onPriceChanged(Product product);
}
