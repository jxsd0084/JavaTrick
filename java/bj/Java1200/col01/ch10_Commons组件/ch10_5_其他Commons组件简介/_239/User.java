package bj.Java1200.col01.ch10_Commons组件.ch10_5_其他Commons组件简介._239;

public class User {

	private int    id;
	private String username;
	private String password;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername( String username ) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword( String password ) {

		this.password = password;
	}

	@Override
	public String toString() {

		return "序号：" + id + "，用户名：" + username + "，密码：" + password;
	}
}
