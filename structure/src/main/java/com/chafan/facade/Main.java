package com.chafan.facade;


import com.chafan.facade.organization.Company;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		Facade facade = new Facade();
		Company c = facade.openCompany("小鱼科技");
		System.out.println(c);
	}
}
