package bj.powernode.basic.day06.userlogin;


public class User {

	//  属性
	private String username;
	private String password;


	//  构造方法
	public User() {

	}

	public User( String username, String password ) {

		this.username = username;
		this.password = password;
	}


	//  实例方法
	public void setUsername( String username ) {

		this.username = username;
	}

	public String getUsername() {

		return username;
	}

	public void setPassword( String password ) {

		this.password = password;
	}

	public String getPassword() {

		return password;
	}

}
