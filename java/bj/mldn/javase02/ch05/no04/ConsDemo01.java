package bj.mldn.javase02.ch05.no04;

class Person1 {

	public Person1() {        // 声明构造方法
		System.out.println( "一个新的Person对象产生。" );
	}
}

public class ConsDemo01 {

	public static void main( String args[] ) {

		System.out.println( "声明对象：Person per = null ;" );
		Person1 per = null;    // 声明对象时并不去调用构造方法
		System.out.println( "实例化对象：per = new Person() ;" );
		per = new Person1();//实例化对象
	}
};
