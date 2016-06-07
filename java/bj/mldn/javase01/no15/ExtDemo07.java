package bj.mldn.javase01.no15;

class Person4 {

	private String name;
	private int    age;

	public Person4() {

		System.out.println( "******************" );
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
};

class Student4 extends Person4 {

	private String school;    // 扩充的属性

	public Student4() {

		super();    // 隐藏了此语句
		System.out.println( "===================" );
	}

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}
}

public class ExtDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Student4 stu = new Student4();    //  学生
	}

}
