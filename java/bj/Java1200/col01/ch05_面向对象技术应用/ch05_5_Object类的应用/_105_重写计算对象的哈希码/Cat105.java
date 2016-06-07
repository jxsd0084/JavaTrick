package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._105_重写计算对象的哈希码;

import java.awt.*;

public class Cat105 {

	private String name;
	private int    age;
	private double weight;
	private Color  color;

	public Cat105( String name, int age, double weight, Color color ) {

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
		Cat105 cat = (Cat105) obj;
		return name.equals( cat.name ) && ( age == cat.age ) && ( weight == cat.weight ) && ( color.equals( cat.color ) );
	}

	@Override
	public int hashCode() {

		return 7 * name.hashCode() + 11 * new Integer( age ).hashCode() + 13 * new Double( weight ).hashCode() + 17 * color.hashCode();
	}
}
