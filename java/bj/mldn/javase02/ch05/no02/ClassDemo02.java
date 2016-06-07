package bj.mldn.javase02.ch05.no02;

class Person1 {

	String name;        // 声明姓名属性
	int    age;         // 声明年龄属性

	public void tell() {    // 取得信息
		System.out.println( "姓名：" + name + "，年龄：" + age );
	}
}

public class ClassDemo02 {

	public static void main( String args[] ) {
		//Person per = new Person() ;	// 创建并实例化对象
		Person1 per = null;             // 声明对象
		per = new Person1();            // 实例化对象
	}
}
