package com.bjpowernode.spring.bean;

import java.util.*;

public class User {

	public User() {
		//System.out.println( "user 构造方法" );
	}

	public User( String usercode, Integer age ) {
		this.usercode = usercode;
		this.age = age;
	}

	private String  username;
	private String  usercode;
	private Integer age;
	private User[]  firends;

	private List< String > stringList;
	private List           objList;
	private HashMap        map;
	private Set            set;
	private Properties     prop;

	private Date date;

	private Classes classes;

	public Classes getClasses() {
		return classes;
	}

	public void setClasses( Classes classes ) {
		this.classes = classes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode( String usercode ) {
		this.usercode = usercode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge( Integer age ) {
		this.age = age;
	}

	public User[] getFirends() {
		return firends;
	}

	public void setFirends( User[] firends ) {
		this.firends = firends;
	}

	public List< String > getStringList() {
		return stringList;
	}

	public void setStringList( List< String > stringList ) {
		this.stringList = stringList;
	}

	public List getObjList() {
		return objList;
	}

	public void setObjList( List objList ) {
		this.objList = objList;
	}

	public Set getSet() {
		return set;
	}

	public void setSet( Set set ) {
		this.set = set;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp( Properties prop ) {
		this.prop = prop;
	}

	public HashMap getMap() {
		return map;
	}

	public void setMap( HashMap map ) {
		this.map = map;
	}
}
