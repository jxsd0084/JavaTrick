package bj.mldn.javase02.ch05.no01;

class Person2 {

	// 人中有姓名和年龄两个属性
	String name;        // 表示姓名
	int    age;         // 表示年龄

	public void tell() {

		System.out.println( "姓名：" + name + "；年龄：" + age );
	}
};

public class ClassDemo02 {

	public static void main( String args[] ) {

		Person2 per = new Person2();
	}

}
