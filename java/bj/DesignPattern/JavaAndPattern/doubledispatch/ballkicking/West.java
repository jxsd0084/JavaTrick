package bj.DesignPattern.JavaAndPattern.doubledispatch.ballkicking;

public class West {

	public void goWest( East east ) {
		east.goEast( this );
	}

}
