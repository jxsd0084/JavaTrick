package bj.mldn.javase02.ch05.no03;

class Person2 {

	private String name;            // 声明姓名属性
	private int    age;             // 声明年龄属性

	public void tell() {

		System.out.println( "姓名：" + name + "，年龄：" + age );
	}

}

public class EncDemo02 {

	public static void main( String arsgh[] ) {

		Person2 per = new Person2();    // 声明并实例化对象
/*		per.name = "张三";               // 为name属性赋值
		per.age = - 30;                 // 为age属性赋值*/
		per.tell();
	}
}
