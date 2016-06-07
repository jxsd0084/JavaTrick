package bj.powernode.advance.Charpter17.test2.domain;

import java.sql.*;

// 域对象
public class Users {

	private int    id;
	private String name;
	private String sex;
	private String password;
	private Date   birthday;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getSex() {

		return sex;
	}

	public void setSex( String sex ) {

		this.sex = sex;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword( String password ) {

		this.password = password;
	}

	public Date getBirthday() {

		return birthday;
	}

	public void setBirthday( Date birthday ) {

		this.birthday = birthday;
	}
}
