package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._100_计算几何图形的面积;

public abstract class Shape {

	public String getName() {

		return this.getClass().getSimpleName();
	}

	public abstract double getArea();

}
