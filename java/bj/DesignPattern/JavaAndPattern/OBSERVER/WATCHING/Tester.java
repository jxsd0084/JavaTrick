package bj.DesignPattern.JavaAndPattern.OBSERVER.WATCHING;

import java.util.Observer;

public class Tester {

	static private Watched  watched;
	static private Observer watcher;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		watched = new Watched();

		watcher = new Watcher( watched );

		watched.changeData( "In C, we create bugs." );
		watched.changeData( "In Java, we inherit bugs." );
		watched.changeData( "In Java, we inherit bugs." );
		watched.changeData( "In Visual Basic, we visualize bugs." );
	}

}
