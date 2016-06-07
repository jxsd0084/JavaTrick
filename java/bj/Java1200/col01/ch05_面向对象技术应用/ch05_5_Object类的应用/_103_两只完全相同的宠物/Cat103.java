package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._103_两只完全相同的宠物;

import java.awt.*;

public class Cat103 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat103( String name, int age, double weight, Color color ) {

		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( getClass() != obj.getClass() ) {
			return false;
		}
		Cat103 cat = (Cat103) obj;
		return name.equals( cat.name ) && ( age == cat.age ) && ( weight == cat.weight ) && ( color.equals( cat.color ) );
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
