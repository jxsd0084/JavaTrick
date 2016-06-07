package bj.powernode.advance.Charpter05.test1;

public class Student extends Person {

	private String course;

	{
		System.out.println( "Student的初始化块被调用" );
	}

	public String getCourse() {

		return course;
	}

	public void setCourse( String course ) {

		this.course = course;
	}

	public Student() {

	}

	public Student( String name, int age ) {

		super( name, age );
		System.out.println( "Student的两个参数被调用" );
	}

	public Student( String name, int age, String course ) {

		this( name, age );
		this.course = course;
		System.out.println( "Student的三个参数被调用" );
	}

}
