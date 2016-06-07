package bj.mldn.javase01.no55.localedemo;

import java.util.ListResourceBundle;

public class Message_zh_CN extends ListResourceBundle {

	Object data[][] = {
			{ "info", "你好，{0}，年龄：{1}！" }
	};

	protected Object[][] getContents() {

		return this.data;
	}

}
