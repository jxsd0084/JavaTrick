package bj.mldn.javase02.ch06.no02;

class Person6 {                    // 定义Person类

	private String name;        // 定义name属性
	private int    age;            // 定义age属性

	public Person6( String name, int age ) {

		this.setName( name );
		this.setAge( age );
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

	public String getInfo() {

		return "姓名：" + this.getName() + "；年龄：" + this.getAge();
	}
}

class Student6 extends Person6 {                    // 定义Student类

	private String school;        // 定义school属性

	public Student6( String name, int age, String school ) {

		super( name, age );    // 明确调用父类中有两个参数的构造
		this.school = school;
	}

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}

	public String getInfo() {

		return super.getInfo() + "；学校：" + this.getSchool();
	}

}

public class SuperDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String arsg[] ) {

		Student6 stu = new Student6( "张三", 30, "清华大学" );// 实例化子类对象
		System.out.println( stu.getInfo() );
	}
}
