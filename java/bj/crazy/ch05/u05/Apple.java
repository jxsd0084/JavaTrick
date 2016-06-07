package bj.crazy.ch05.u05;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Apple {

	public String name;
	public String color;
	public double weight;

	public Apple() {

	}

	// 两个参数的构造器
	public Apple( String name, String color ) {

		this.name = name;
		this.color = color;
	}

	// 三个参数的构造器
	public Apple( String name, String color, double weight ) {

		// 通过this调用另一个重载的构造器的初始化代码
		this( name, color );

		// 下面this引用该构造器正在初始化的Java对象
		this.weight = weight;
	}

}

