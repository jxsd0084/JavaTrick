package bj.Java1200.col01.ch05_面向对象技术应用.ch05_1_Java中类的定义._087_构造方法的应用;

public class Person {

	private String name;
	private String gender;
	private int    age;

	public Person() {

		System.out.println( "使用无参构造方法创建对象" );
	}

	public Person( String name, String gender, int age ) {

		this.name = name;
		this.gender = gender;
		this.age = age;
		System.out.println( "使用有参构造方法创建对象" );
	}

	public String getName() {

		return name;
	}

	public String getGender() {

		return gender;
	}

	public int getAge() {

		return age;
	}

}
