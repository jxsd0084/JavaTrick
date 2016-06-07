package bj.mldn.javase02.ch05.no02;

class Person2 {

	String name;        // 声明姓名属性
	int    age;         // 声明年龄属性

	public void tell() {    // 取得信息
		System.out.println( "姓名：" + name + "，年龄：" + age );
	}
}

public class ClassDemo03 {

	public static void main( String args[] ) {

		Person2 per = null;        // 声明对象
		//per = new Person() ;	   // 实例化对象
		per.name = "张三";          // 为姓名赋值
		per.age = 30;              // 为年龄赋值
		per.tell();                // 调用方法，打印信息
	}
}
