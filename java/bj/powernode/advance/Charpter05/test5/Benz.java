package bj.powernode.advance.Charpter05.test5;

public class Benz extends Car {

	@Override
	public void run() {

		System.out.println( "Benz在以180迈的速度行驶" );
	}

	@Override
	public void stop() {

		System.out.println( "Benz在刹车" );
	}

}
