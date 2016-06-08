package bj.DesignPattern.JavaPattern._01_单一职责原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ConnectionManager implements IConnectionManager {
	
	@Override
	public void dial( String phoneNumber ) {

		System.out.println( "dial..." );
	}

	@Override
	public void huangup() {

		System.out.println( "huangup" );
	}

}
