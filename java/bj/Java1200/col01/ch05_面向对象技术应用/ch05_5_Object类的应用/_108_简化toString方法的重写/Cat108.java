package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._108_简化toString方法的重写;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.awt.*;

public class Cat108 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat108( String name, int age, double weight, Color color ) {

		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}

	@Override
	public String toString() {

		return new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE ).append( name ).append( age ).append( weight ).append( color ).toString();
	}
}
