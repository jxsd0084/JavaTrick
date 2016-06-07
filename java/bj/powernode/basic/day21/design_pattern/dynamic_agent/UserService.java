package bj.powernode.basic.day21.design_pattern.dynamic_agent;

public class UserService {  //另一个目标类

	public boolean login( String username, String password ) {  //目标方法
		return ( "admin".equals( username ) ) && ( "123".equals( password ) );
	}

}
