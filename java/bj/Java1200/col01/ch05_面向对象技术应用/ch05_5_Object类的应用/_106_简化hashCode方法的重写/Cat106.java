package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._106_简化hashCode方法的重写;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.awt.*;

public class Cat106 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat106( String name, int age, double weight, Color color ) {

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
		Cat106 cat = (Cat106) obj;
		return new EqualsBuilder().append( name, cat.name ).append( age, cat.age ).append( weight, cat.weight ).append( color, cat.color ).isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append( name ).append( age ).append( weight ).append( color ).toHashCode();
	}

}
