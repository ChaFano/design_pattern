package com.chafan.memento;



/**
 * @Auther: 茶凡
 * @ClassName ApiTest
 * @date 2023/11/21 15:19
 * @Description 备忘录模式 记录某一时刻 字符在的状态 在指定的时候恢复 状态
 */
public class ApiTest {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        editor.add("Hello");
        editor.add(',');
        editor.delete();
        editor.add(' ');
        editor.add("world");
        // 保存状态:
        String state = editor.getState();
        // 继续编辑:
        editor.add("!!!");
        editor.delete();
        editor.print();

        // 恢复状态:
        editor.setState(state);
        editor.print();
    }
}
