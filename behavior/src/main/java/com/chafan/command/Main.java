package com.chafan.command;



// 命令模式测试
public class Main {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		editor.add("Command pattern in text editor.\n");

		//Invoke invoke = new Invoke();

		Command copy = new CopyCommand(editor);
		copy.execute();

		editor.add("----\n");
		Command paste = new PasteCommand(editor);

//		invoke.add(copy);
//		invoke.add(paste);

		//invoke.invoke();

		paste.execute();
		System.out.println(editor.getState());
	}
}
