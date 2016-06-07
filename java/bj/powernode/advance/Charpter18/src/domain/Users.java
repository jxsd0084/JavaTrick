package bj.powernode.advance.Charpter18.src.domain;

import java.sql.*;

// domain包下面主要存放的是抽象出来的表的对象
// 数据库表的每一个字段对应对象的一个属性
public class Users {

	// 属性
	private int    id;
	private String name;
	private String password;
	// 此处导入的Date是sql里面的Date,不是util里面的Date
	private Date   birthday;

	// set/get方法
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
