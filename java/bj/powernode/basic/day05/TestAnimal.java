

//  定义包结构
package bj.powernode.basic.day05;

public class TestAnimal {

	//  主方法
	public static void main( String[] args ) {

		//  访问Animal对象的age属性.
		//  创建Animal类型的对象
		Animal a = new Animal();

		//  访问
		//  外部程序可以随意访问Animal的age属性.age属性很不安全.
		//  a.age = -100;


		//  打印
		//  System.out.println(a.age);


		//  结论:类的私有化的属性无法在外部程序中直接访问.
		//  从根本上保护了 age的属性，保证了age属性的安全.合法.

		//  赋值
		a.setAge( - 100 );


		//  读取值
		int age = a.getAge();
		System.out.println( "age=" + age );


	}

}
