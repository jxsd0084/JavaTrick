package bj.powernode.basic.day16.reflect;

public class User {

	// 属性
	private String username = null;

	public static int    age;
	protected     String email;

	Boolean gender;


	// 构造方法
	public User() {

	}

	public User( String username, String email, Boolean gender ) {

		this.username = username;
		this.email = email;
		this.gender = gender;
	}


	// 方法.
	public static void shopping() {

		System.out.println( "User is shopping.." );
	}

	public void m() {

		System.out.println( "m method invoked!" );
	}

	public String eat( String food ) {

		return "eating " + food;
	}


	public int add( int a, int b, int c ) {

		return a + b + c;
	}


	// 重写toString方法
	public String toString() {

		return username + "\t" + email + "\t" + ( gender ? "男" : "女" );
	}


}
