package bj.powernode.basic.day21.dpp.service;

public class UserService {

	public boolean login( String username, String password ) {
		try {
			Thread.sleep( 6000 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		return ( "admin".equals( username ) ) && ( "123".equals( password ) );
	}
}
