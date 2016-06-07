package bj.powernode.basic.day06.TestAbstract;

/*

	关于java语言中的抽象类
	
	什么是抽象类？ class关键字前面有abstract关键字的,该类就是一个抽象类.
	
	抽象类有什么作用？ 需要项目.(暂时可以不理解)
	
	现阶段需要掌握：
		1.如何定义抽象类
		2.如何定义抽象方法.(没有实现体的方法.)
		
	语法规则：
		1.抽象类不能被实例化. (无法new出来)
		2.抽象方法必须出现在抽象类中。
		3.一个非抽象的类继承抽象类，必须重写抽象类中的抽象方法.
	
	判断：抽象类中肯定有抽象方法. (错误)

*/

public abstract class Animal extends Object {  //   Animal类是一个抽象类.

	//  属性
	private String name;
	private int    age;


	//  构造方法(供子类调用使用.)
	public Animal() {

		System.out.println( "Animal的无参数构造方法执行." );
	}

	public Animal( String name, int age ) {

		this.name = name;
		this.age = age;
	}


	//  定义实例方法
	public void sing() {

		System.out.println( "Animal is sing a song." );
	}

	//  定义抽象方法
	public abstract void eat();


	//  主方法
	public static void main( String[] args ) {

		//  Animal a = new Animal();  //    抽象类无法实例化

	}

}


class Cat extends Animal {


	public Cat() {

		super();
	}


	//  这个重写的过程我们通常又叫做 “实现”
	public void eat() {

		System.out.println( "Cat eat." );
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Cat cat = new Cat();

	}

}
