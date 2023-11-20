package com.chafan.composite;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/20 21:06
 * @Description TODO
 */
public class ApiTest {

    public static void main(String[] args) {
        Node root = new ElementNode("school");

        root.add(new ElementNode("classA")
                .add(new TextNode("Tom"))
                .add(new TextNode("Alice"))
        );

        root.add(new ElementNode("classB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Grace"))
                .add(new CommentNode("comment..."))
        );
        System.out.println(root.toXml());
    }

}
