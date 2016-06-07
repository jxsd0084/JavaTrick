package bj.powernode.basic.day03;

//  讲解java中的方法
//  什么是方法 : 一段可以被重复使用的代码片段.
/*
	结构:
		[修饰符1 修饰符2....] 返回值类型 方法名(形式参数1,形式参数2,形式参数3.....){
			方法体;
		}
		
		注意:形式参数之间需要用 , 隔开.
		     形式参数是局部变量. 需要这样定义：(int i,int k,int j,double d)
		     
		注意:如果设计的时候,不需要该方法返回值,那么定义的时候返回值类型就是 void
		     如果希望该方法在执行结束之后能够在外部获取该方法执行的结果,那么该方法在设计时候就需要返回值.
*/

public class _06_Method {


	//  方法1
	//  该方法没有返回值,没有参数列表.
	public static void m1() {

		System.out.println( "m1 方法执行." );
	}


	//  方法2
	//  希望该方法返回一个int类型的值
	public static int sum( int a, int b ) {  // a,b形参

		int result = a + b;
		//  如何返回一个值.(return关键字)
		return result;

	}


	//  方法3
	public static void m3() {

		return; //  return 作用:1,返回值 2.结束方法.

		//  System.out.println("m3 execute here!");

	}

	//  方法4
	public static void m4( int a ) {

		if ( a > 100 ) {

			return;
		}
		//  如果程序能够执行到此处就代表 a<=100

		System.out.println( "a值小于等于100." );
	}


	//  方法5
	public static boolean login( String username, String password ) {

		//  如何判断两个字符串是否一致.
		
		/*
			1==1 执行结果 true
			1==2 执行结果 false
			"abc".equals("def") 执行结果 false
			"abc".equals("abc") 执行结果 true
		*/


		//  如果用户名是robin并且密码是456,我们就返回true,其他情况一律返回false
		if ( username.equals( "robin" ) && password.equals( "456" ) ) {

			return true;
		}

		return false;
	}


	//  程序的入口
	public static void main( String[] args ) {

		//  如何在main方法中让m1方法执行.

		//  在java程序中如何去执行某一个方法:
		//	包括两种方式
		//		类名.方法名(实参列表)   
		//		对象名.方法名(实参列表)

		_06_Method.m1();





		//  执行sum方法.
		int sumResult = _06_Method.sum( 10, 20 );      //10 20实参

		System.out.println( "求和结果=" + sumResult );






		//  再次调用sum方法.
		int sumResult2 = _06_Method.sum( 100, 200 );

		System.out.println( "求和结果2=" + sumResult2 );







		//  调用login方法.
		boolean b = _06_Method.login( "robin", "456" );

		System.out.println( b ? "登录成功" : "登录失败" );





	}

}
