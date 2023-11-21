package com.chafan.flyweight;


public class Main {

	public static void main(String[] args) {
		Student s1 = Student.create(1, "小明");
		Student s2 = Student.create(2, "小红");
		Student s3 = Student.create(1, "小明");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s3); // true
		System.out.println("***************************************");
		Integer n1 = Integer.valueOf(100);
		Integer n2 = Integer.valueOf(100);
		System.out.println(n1 == n2); // true


	}
}
