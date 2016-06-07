package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._104_简化equals方法的重写;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.awt.*;

public class Cat104 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat104( String name, int age, double weight, Color color ) {

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
		Cat104 cat = (Cat104) obj;
		return new EqualsBuilder().append( name, cat.name ).append( age, cat.age ).append( weight, cat.weight ).append( color, cat.color ).isEquals();
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
