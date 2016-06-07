package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._100_计算几何图形的面积;

public class Rectangle extends Shape {

	private double length;
	private double width;

	public Rectangle( double length, double width ) {

		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {

		return length * width;
	}

}
