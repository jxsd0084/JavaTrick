package com.bjpowernode.hibernate.bean;

import java.util.Date;

public class User {

	private String  id;
	private String  name;
	private Integer age;
	private Date    regdate;

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge( Integer age ) {
		this.age = age;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate( Date regdate ) {
		this.regdate = regdate;
	}
}
