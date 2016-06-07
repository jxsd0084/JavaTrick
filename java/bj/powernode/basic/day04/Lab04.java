package bj.powernode.basic.day04;

//  创建类
public class Lab04 {

	//  创建m1(int i){}方法
	void m1( int i ) {

		i++;
	}


	public static void main( String[] args ) {

		//  局部变量i
		int i = 100;

		//  创建对象,注意要使用new关键字.
		Lab04 lab04 = new Lab04();

		//  调用方法.
		lab04.m1( i );

		System.out.println( i );    // 100

	}

}
