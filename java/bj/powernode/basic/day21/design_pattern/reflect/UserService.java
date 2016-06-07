package bj.powernode.basic.day21.design_pattern.reflect;

public class UserService {

	public boolean login( String username, String password ) {

		return ( "admin".equals( username ) ) && ( "123".equals( password ) );
	}
}
