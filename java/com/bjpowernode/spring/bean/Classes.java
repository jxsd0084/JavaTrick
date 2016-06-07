package com.bjpowernode.spring.bean;

public class Classes {

	public Classes() {
		System.out.println( "Classes ()" );
	}

	private String cid;
	private String cname;
	private User[] users;

	public String getCid() {
		return cid;
	}

	public void setCid( String cid ) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname( String cname ) {
		this.cname = cname;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers( User[] users ) {
		this.users = users;
	}
}
