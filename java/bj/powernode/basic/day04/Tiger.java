package bj.powernode.basic.day04;

/*

	注意：如果一个类定义了有参数的构造方法,无参数构造方法将被覆盖.

*/

//   创建类.
public class Tiger {

	//  无参数构造.

	//  推荐将”无参数构造“写出来.

	Tiger() {

	}

	//  有参构造.

	Tiger( String name ) {

	}

	//  创建主方法.
	public static void main( String[] args ) {

		//  创建对象 new + 构造方法.
		Tiger t = new Tiger();   // 类名 变量名 赋值运算符 new关键字 + 构造方法

	}

}
