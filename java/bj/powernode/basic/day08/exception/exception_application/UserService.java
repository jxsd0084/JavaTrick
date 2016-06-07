package bj.powernode.basic.day08.exception.exception_application;

/*
	用户的业务
*/
public class UserService {

	//注册方法
	public void register( String username ) throws IllegalNameException {  //方法上声明抛出异常

		if ( username.equals( "admin" ) ) {  //普通用户的用户名不能是admin,这是一种异常现象.
			throw new IllegalNameException( "用户名无效." );
		}

		System.out.println( username + "注册成功." );

	}

}
