package com.chafan.decorator;

import java.io.IOException;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/20 22:01
 * @Description TODO
 */
public class ApiTest {

    public static void main(String[] args) throws IOException {
        TextNode n1 = new SpanNode();
        TextNode n2 = new BoldDecorator(new UnderlineDecorator(new SpanNode()));
        TextNode n3 = new ItalicDecorator(new BoldDecorator(new SpanNode()));
        n1.setText("Hello");
        n2.setText("Decorated");
        n3.setText("World");
        System.out.println(n1.getText());
        System.out.println(n2.getText());
        System.out.println(n3.getText());
    }

}
