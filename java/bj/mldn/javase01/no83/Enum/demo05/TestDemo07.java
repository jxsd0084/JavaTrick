package bj.mldn.javase01.no83.Enum.demo05;

public class TestDemo07 {

	public static void main(String[] args) {

		for (Color c : Color.values()) { // 取得全部的枚举内容
			System.out.println(c.getColor());
		}
	}

}
