package bj.mldn.javase01.no83.Class.demo.classdemo01;

public class ClassInstanceDemo01 {

	public static void main(String[] args) {

		Person   per = new Person();    // 实例化对象
		Class<?> c   = per.getClass();  // 为Class对象实例化
		System.out.println(c.getName());
	}

}
