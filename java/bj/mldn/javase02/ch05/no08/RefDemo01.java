package bj.mldn.javase02.ch05.no08;

class Demo1 {

	int temp = 30;        // 此处为了方便，属性暂时不封装
}

public class RefDemo01 {

	public static void main( String args[] ) {

		Demo1 d1 = new Demo1();    // 实例化Demo对象，实例化之后里面的temp=30
		d1.temp = 50;              // 修改temp属性的内容

		System.out.println( "fun()方法调用之前：" + d1.temp );

		fun( d1 );
		System.out.println( "fun()方法调用之后：" + d1.temp );
	}

	public static void fun( Demo1 d2 ) {       // 此处的方法由主方法直接调用
		d2.temp = 1000;                        // 修改temp值
	}

}
