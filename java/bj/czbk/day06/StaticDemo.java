package bj.czbk.day06;

/*


静态：static。

用法：是一个修饰符，用于修饰成员(成员变量，成员函数).
当成员被静态修饰后，就多了一个调用方式，除了可以被对象调用外，
还可以直接被类名调用。类名.静态成员。


static特点：

1，随着类的加载而加载。
   也就说：静态会随着类的消失而消失。说明它的生命周期最长。

2，优先于的对象存在
明确一点：静态是先存在。对象是后存在的。

3，被所有对象所共享

4，可以直接被类名所调用。



实例变量和类变量的区别：

1，存放位置。
	类变量随着类的加载而存在于方法区中。
	实例变量随着对象的建立而存在于堆内存中。
2，生命周期：
	类变量生命周期最长，随着类的消失而消失。
	实例变量生命周期随着对象的消失而消失。



静态使用注意事项：

1，静态方法只能访问静态成员。
	非静态方法既可以访问静态也可以访问非静态。
2，静态方法中不可以定义this，super关键字。
	因为静态优先于对象存在。所以静态方法中不可以出现this。
3，主函数是静态的。
	


静态有利有弊

利处：对对象的共享数据进行单独空间的存储，节省空间。没有必要每一个对象中都存储一份。
	可以直接被类名调用。
弊端：生命周期过长。
	  访问出现局限性。(静态虽好，只能访问静态。)


*/

class Person2 {

	String name;                    //  成员变量，实例变量。
	static String country = "CN";   //  静态的成员变量，类变量。

	public static void show() {

		System.out.println( "::::" );
		//  this.haha();
	}

	public void haha() {

	}
}

class StaticDemo2 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Person2 p = new Person2();
		//  p.name = "zhangsan";
		//  p.show();

		//  System.out.println(p.country);
		//  System.out.println(Person.country);

		Person2.show();
	}
}
