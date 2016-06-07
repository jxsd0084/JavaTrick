package bj.mldn.javase02.ch06.no02;

class Person {                    // 定义Person类

	private String name;        // 定义name属性
	private int    age;            // 定义age属性

	public Person() {

		System.out.println( "父类Person中的构造。" );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

class Student extends Person {                    // 定义Student类

	private String school;        // 定义school属性

	public Student() {

		super();    // 默认隐藏
		System.out.println( "子类Student中的构造。" );
	}

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}

}

public class InstanceDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String arsg[] ) {

		Student stu = new Student();// 实例化子类对象
		stu.setName( "张三" );    // 此方法在Student类中没有明确定义
		stu.setAge( 30 );
		stu.setSchool( "清华大学" );
		System.out.println( "姓名：" + stu.getName() + "，年龄：" + stu.getAge() + "，学校：" + stu.getSchool() );
	}
}
