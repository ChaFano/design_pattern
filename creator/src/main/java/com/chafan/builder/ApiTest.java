package com.chafan.builder;

import com.chafan.builder.html.HtmlBuilder;
import com.chafan.builder.url.URLBuilder;

import java.util.Map;

/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/16 23:04
 * @Description 生成器模式测试
 */
public class ApiTest {

    public static void main(String[] args) {

        String markdown = String.join("\n", // Markdown document
                "## Builder Pattern", // heading
                "> Seperate the construction of a complex object from its representation",
                "Use builder pattern when the construction process is complex.", "----", "Here is an example.");
        HtmlBuilder builder = new HtmlBuilder();
        String html = builder.toHtml(markdown);
        System.out.println(html);

        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.liaoxuefeng.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }
}
