package bj.DesignPattern.JavaAndPattern.doubledispatch.ballkicking;

public class East {

	public void goEast( West west ) {
		west.goWest( this );
	}

}
