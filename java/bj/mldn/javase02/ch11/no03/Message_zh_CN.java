package bj.mldn.javase02.ch11.no03;

import java.util.ListResourceBundle;

public class Message_zh_CN extends ListResourceBundle {

	private final Object data[][] = {
			{ "info", "中文，你好，{0}！" }
	};

	public Object[][] getContents() {    // 覆写的方法
		return data;
	}
}
