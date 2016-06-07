package bj.powernode.basic.day21.design_pattern.exercise;

public class UserService {

	public boolean login( String username, String password ) {

		try {
			//模拟耗时
			Thread.sleep( 1452 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}

		if ( "admin".equals( username ) && "123".equals( password ) ) {
			return true;
		}

		return false;
	}


	//注销用户的功能
	public void disable() {

		try {
			//模拟耗时
			Thread.sleep( 1452 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}

}
