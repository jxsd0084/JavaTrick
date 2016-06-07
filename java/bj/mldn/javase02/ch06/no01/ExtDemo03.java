package bj.mldn.javase02.ch06.no01;

class Person3 {                 // 定义Person类

	private String name;        // 定义name属性
	private int    age;         // 定义age属性

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

class Student3 extends Person3 {                    // 定义Student类

	private String school;        // 定义school属性

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}

}

public class ExtDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String arsg[] ) {

		Student3 stu = new Student3();   // 实例化子类对象
		stu.setName( "张三" );            // 此方法在Student类中没有明确定义
		stu.setAge( 30 );
		stu.setSchool( "清华大学" );
		System.out.println( "姓名：" + stu.getName() +
		                    "，年龄：" + stu.getAge() +
		                    "，学校：" + stu.getSchool() );
	}

}
