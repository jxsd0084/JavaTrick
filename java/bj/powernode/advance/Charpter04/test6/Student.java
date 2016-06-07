package bj.powernode.advance.Charpter04.test6;

public class Student extends Person {

	private String schoolName;

	public String getSchoolName() {

		return schoolName;
	}

	public void setSchoolName( String schoolName ) {

		this.schoolName = schoolName;
	}

	public Student() {
		// super()去调用父类默认的无参数的构造方法
		super();
		System.out.println( "子类的无参数构造方法被调用" );
	}

	public Student( String name, int age ) {
		// super被当做指向父类对象的一个引用来使用
		// super.setAge(age);
		// super.setName(name);

		// suepr() 去调用父类中已经存在的有参数的构造方法
		// super()当做构造方法来使用的时候,必须要放在
		// 构造方法的第一行

		super( name, age );
		System.out.println( "子类的两个参数构造方法被调用" );
	}

	public Student( String name, int age, String schoolName ) {

		this( name, age );
		this.schoolName = schoolName;
		System.out.println( "子类的三个参数构造方法被调用" );
	}

}
