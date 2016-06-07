package bj.Java1200.col01.ch06_多线程技术.ch06_3_线程的进阶._145;

public class ChopstickArray {

	private Chopstick[] chopsticks;

	public ChopstickArray( int size ) {

		chopsticks = new Chopstick[ size ];
		for ( int i = 0; i < chopsticks.length; i++ ) {
			chopsticks[ i ] = new Chopstick( i );
		}
	}

	public Chopstick get( int id ) {

		return chopsticks[ id ];
	}

	public Chopstick getLast( int id ) {

		if ( id == 0 ) {
			return chopsticks[ chopsticks.length - 1 ];
		} else {
			return chopsticks[ id - 1 ];
		}
	}
}
