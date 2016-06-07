package bj.mldn.javase01.no83.Enum.demo03;

import java.util.EnumMap;

public class EnumMapDemo {

	public static void main(String[] args) {

		EnumMap<Color, String> emap = new EnumMap<Color, String>(Color.class);
		emap.put(Color.RED, "红色");
		emap.put(Color.GREEN, "绿色");
		emap.put(Color.BLUE, "蓝色");
		System.out.println(emap.get(Color.RED));
		;

	}

}
