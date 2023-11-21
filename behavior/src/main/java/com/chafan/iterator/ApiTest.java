package com.chafan.iterator;

import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/21 11:23
 * @Description 迭代器模式
 */
public class ApiTest {

    public static void main(String[] args) {
        ReverseArrayCollection<String> rarray = new ReverseArrayCollection<String>("apple", "pear", "orange", "banana");
        for (String fruit : rarray) {
            System.out.println(fruit);
        }
    }
}
