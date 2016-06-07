package bj.powernode.basic.day04;
/*
	构造方法的作用: 
	
		1.创建对象.
		
		2.给对象的成员变量赋值.(给对象的属性赋值)
	
		3.初始化对象.

*/

//  创建类/Bird
public class Bird {

	//  成员变量 (属性).
	String name;

	int age;

	/* 构造方法. */

	//  无参数构造.
	Bird() {

	}

	//  有参构造.
	Bird( String _name ) {
		name = _name;
	}

	//  有参构造.
	Bird( String _name, int _age ) {
		name = _name;
		age = _age;
	}


	//  程序的入口
	public static void main( String[] args ) {

		//  在主方法内调用无参数构造方法.
		Bird b1 = new Bird();

		System.out.println( b1.name );  //  null
		System.out.println( b1.age );   //  0


		//  在主方法内调用有参数构造方法(给name属性赋值).
		Bird b2 = new Bird( "鹦鹉" );

		System.out.println( b2.name );  //  鹦鹉
		System.out.println( b2.age );   //  0


		//  在主方法内调用有参数构造方法(给name,age属性赋值).
		Bird b3 = new Bird( "老鹰", 3 );

		System.out.println( b3.name );  //   老鹰
		System.out.println( b3.age );   //   3

	}

}
