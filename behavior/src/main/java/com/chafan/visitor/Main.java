package com.chafan.visitor;


import java.io.File;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		FileStructure fs = new FileStructure(new File("."));
		fs.handle(new JavaFileVisitor());
		fs.handle(new ClassFileCleanerVisitor());
	}
}
