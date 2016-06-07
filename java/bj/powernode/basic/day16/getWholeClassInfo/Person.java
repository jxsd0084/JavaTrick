package bj.powernode.basic.day16.getWholeClassInfo;

import java.util.Date;

public class Person {

	// 属性
	private Date birthday;

	private boolean gender;

	private String id;

	private String name;


	// 构造方法
	public Person() {

		super();
	}

	public Person( String id, String name, boolean gender, Date birthday ) {

		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}


	// setter and getter
	public Date getBirthday() {

		return birthday;
	}

	public String getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public boolean isGender() {

		return gender;
	}

	public void setBirthday( Date birthday ) {

		this.birthday = birthday;
	}

	public void setGender( boolean gender ) {

		this.gender = gender;
	}

	public void setId( String id ) {

		this.id = id;
	}

	public void setName( String name ) {

		this.name = name;
	}


	// 吃
	public void eat( String food ) {

		System.out.println( name + "在吃" + food );
	}

	// dancing
	public void dancing( String s ) {

		System.out.println( name + "在跳" + s );
	}


}
