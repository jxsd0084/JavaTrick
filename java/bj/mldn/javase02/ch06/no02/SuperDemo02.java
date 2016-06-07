package bj.mldn.javase02.ch06.no02;

class Person7 {                    // 定义Person类

	private String name;        // 定义name属性
	private int    age;            // 定义age属性

	public Person7( String name, int age ) {

		this.name = name;
		this.age = age;
	}
}

class Student7 extends Person7 {                    // 定义Student类

	private String school;        // 定义school属性

	public Student7( String name, int age, String school ) {

		super( name, age );
		this.school = school;
	}

	/*	public Student7() {
		// this("LXH",30,"MLDN") ;
		// 会在此处调用父类的构造，默认调用的是无参
	}

	public Student7(String name, int age) {

		this();
	}

	public Student7(String name, int age, String school) {

		this(name, age);    // 明确调用父类中有两个参数的构造
		this.school = school;
	}*/
}

public class SuperDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String arsg[] ) {

		Student7 stu = new Student7( "张三", 30, "清华大学" );// 实例化子类对象
//		System.out.println(stu.getInfo());
	}
}
