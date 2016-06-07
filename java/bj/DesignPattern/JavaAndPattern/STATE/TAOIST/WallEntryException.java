package bj.DesignPattern.JavaAndPattern.STATE.TAOIST;

public class WallEntryException extends Exception {

	public WallEntryException( String message ) {
		super( message );
		System.out.println( message );
	}

}
