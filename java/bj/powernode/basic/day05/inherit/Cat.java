package bj.powernode.basic.day05.inherit;

public class Cat extends Animal {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//  注意:子类会完全继承父类的所有东西,但是有些东西是无法访问的。
		Cat c = new Cat();

		c.run();

		//  System.out.println(c.name);

	}

}
