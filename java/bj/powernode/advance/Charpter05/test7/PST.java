package bj.powernode.advance.Charpter05.test7;

public class PST implements Car {

	@Override
	public void run() {

		System.out.println( "pst在以150迈的速度行驶" );
	}

	@Override
	public void stop() {

		System.out.println( "pst在刹车" );
	}

}
