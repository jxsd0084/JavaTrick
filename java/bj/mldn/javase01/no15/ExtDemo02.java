package bj.mldn.javase01.no15;

class Person2 {

	private String name;
	private int    age;

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

class Student2 extends Person2 {

}

public class ExtDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Student2 stu = new Student2();    //  学生

		stu.setName( "张三" );    // 从Person继承而来
		stu.setAge( 30 );        // 从Person继承而来

		System.out.println( "姓名：" + stu.getName() );
		System.out.println( "年龄：" + stu.getAge() );

	}

}
