package bj.powernode.basic.day06.casting;


/*

	程序分为两个阶段:

		编译阶段

		运行阶段

*/
public class Test {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {


		Cat c1 = new Cat();
		Cat c2 = new Cat( "tom", 3, "tom's attr" );

		Dog d1 = new Dog();
		Dog d2 = new Dog( "pike", 4, "pike's attr" );


		//子类对象赋值给父类的引用.
		Animal a1 = new Cat(); //动态绑定.(运行阶段绑定)
		Animal a2 = new Cat( "tom", 3, "tom's attr" );

		Animal a3 = new Dog();
		Animal a4 = new Dog( "pike", 4, "pike's attr" );






		//强制类型转换.

		Cat c3 = (Cat) a1;   // 1.语法上是通过的.(编译通过) 2.运行时通过吗？通过.


		//Dog d3 = (Dog)a1;  // 1.语法上是通过的.(编译通过) 2.运行时通过吗？不通过.(类型转换异常 ClassCastException)


		//关键字 instanceof

		//用法:  (对象名 instanceof 类型名) 返回boolean类型.

		//例如：(a1 instanceof Dog) 如果返回true,代表a1对象是Dog的一种类型. 如果返回false,代表a1对象不是Dog的一种类型.

		//推荐：在任何一种类型转换之前用instanceof关键字来判断。

		//instanceof 作用 是判断某个对象是否是一种类型的一个实例  (a instanceof Object) a对象是否是Object类型的一个实例.
		if ( a1 instanceof Dog ) {

			Dog d3 = (Dog) a1;
		}

	}

}
