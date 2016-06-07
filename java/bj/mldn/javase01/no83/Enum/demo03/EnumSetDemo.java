package bj.mldn.javase01.no83.Enum.demo03;

import java.util.EnumSet;

public class EnumSetDemo {

	public static void main(String[] args) {

		EnumSet<Color> eset = null;
		eset = EnumSet.allOf(Color.class); // 将所有的内容设置到集合中
		for (Color x : eset) {
			System.out.println(x);
		}
	}

}
