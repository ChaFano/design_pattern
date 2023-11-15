package com.chafan.abstruct;

import com.chafan.abstruct.factory.FastFactory;
import com.chafan.abstruct.good.GoodFactory;
import com.chafan.abstruct.service.AbstractFactory;
import com.chafan.abstruct.service.HtmlDocument;
import com.chafan.abstruct.service.WordDocument;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/14 23:25
 * @Description 抽象工厂测试
 */
public class ApiTest {

    public static void main(String[] args) throws IOException {

        AbstractFactory fastFactory = new FastFactory();

        HtmlDocument fastHtml = fastFactory.createHtml("#Hello\nHello, world!");
        System.out.println(fastHtml.toHtml());
        fastHtml.save(Paths.get(".", "fast.html"));

        WordDocument fastWord = fastFactory.createWord("#Hello\nHello, world!");
        fastWord.save(Paths.get(".", "fast.doc"));

        AbstractFactory goodFactory = new GoodFactory();

        HtmlDocument goodHtml = goodFactory.createHtml("#Hello\nHello, world!");
        System.out.println(goodHtml.toHtml());
        goodHtml.save(Paths.get(".", "good.html"));

        WordDocument goodWord = goodFactory.createWord("#Hello\nHello, world!");
        goodWord.save(Paths.get(".", "good.doc"));

    }

}
