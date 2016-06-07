package bj.powernode.basic.day05;

//  定义包结构

/*

	java语言中规范要求
		1.类的属性私有化 (在成员变量前加private关键字)
		2.给每一个属性提供公开的访问方法.(公开赋值方法,公开的获取值的方法)

	为什么？
		如果属性没有私有化(没有private),属性在外部程序中可以被随意访问,这样会导致数据的不安全.
		为了解决这个问题,我们应该将属性私有化,并且给每一个属性提供公开的访问方法(set,get).
		
	set方法和get方法在起名字的时候也是有规范的.
		规范规定这样起名字: set+属性名(第一个字母大写)    get+属性名(第一个字母大写)

*/
public class Animal {

	//  1.如果类的属性没有私有化会导致什么结果？

	//  没有私有化
	//  int age;

	// 将age属性私有化.只在当前类中可以直接访问.
	private int age;


	//  提供给age属性赋值的方法
	public void setAge( int _age ) {

		if ( age > 0 && age < 100 ) {  //年龄是合法的
			age = _age;
		} else {
			System.out.println( "年龄" + _age + "不合法." );
		}
	}


	//  提供获取age属性值的方法.
	public int getAge() {

		return age;
	}

}
