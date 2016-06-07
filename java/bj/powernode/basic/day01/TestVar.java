package bj.powernode.basic.day01;

//  定义一个公开的类,类名需要和文件名一致
public class TestVar {

	//  类体内,方法外
	//  在类体内,方法外声明的int类型的值,如果没有赋值,系统会自动赋值 0
	static int    k;
	static double d;  //默认值: 0.0

	//  程序的主入口
	public static void main( String[] args ) {  //  方法的参数列表中的参数是局部变量.

		//  变量的使用，需要先申请(声明),后赋值,再使用.
		int i;



		i = 100;
		System.out.println( i );




		i = 120;
		System.out.println( i );




		int j = 100;
		System.out.println( j );




		//输出k
		System.out.println( k );

	}

}


//  定一个Animal类
/*
	变量分类,按照声明的位置不同,可以将变量分为：局部变量和成员变量
*/
class Animal {

	//  成员变量：定义在类体内，方法外的变量
	String username = "sun";

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  局部变量:方法或语句块内部定义的变量
		int m = 100;                    // 局部变量

		boolean flag = true;            // 局部变量

		if ( flag ) {                   // if语句：如果flag是true,就执行{}里的代码.
			String username = "jack";   // 局部变量
			System.out.println( username );
		}

		//  由于局部变量的作用域,下述语句错误。无法访问username变量.
		//  出了大括号就不认识你了。
		//  System.out.println(username);

	}

}
