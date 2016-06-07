package bj.powernode.basic.day06.userlogin;


/*
	业务类，主要功能是抽象业务方法
		例如：登录的业务方法

*/

public class UserService {

	public boolean login( String username, String password ) {

		//  如果 username是 admin ,密码是 123 ，代表登录成功.
		if ( username.equals( "admin" ) && password.equals( "123" ) ) {

			return true;
		}

		return false;
	}

}
