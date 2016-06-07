package bj.mldn.javase01.no15;

class Person5 {

	private String name;
	private int    age;

	public Person5( String name, int age ) {

		this.name = name;
		this.age = age;
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

class Student5 extends Person5 {

	private String school;    // 扩充的属性

	public Student5( String name, int age, String school ) {

		super( name, age );    // 明确调用父类中有两个参数的构造方法
		this.school = school;
	}

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}
}

public class ExtDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Student5 stu = new Student5( "张三", 30, "清华大学" );    //  学生

		System.out.println( "姓名：" + stu.getName() );
		System.out.println( "年龄：" + stu.getAge() );
		System.out.println( "学校：" + stu.getSchool() );

	}

}
