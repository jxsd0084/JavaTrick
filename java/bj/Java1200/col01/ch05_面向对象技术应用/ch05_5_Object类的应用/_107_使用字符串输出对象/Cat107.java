package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._107_使用字符串输出对象;

import java.awt.*;

public class Cat107 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat107( String name, int age, double weight, Color color ) {

		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append( "名字：" + name + "\n" );
		sb.append( "年龄：" + age + "\n" );
		sb.append( "重量：" + weight + "\n" );
		sb.append( "颜色：" + color + "\n" );
		return sb.toString();
	}
}
