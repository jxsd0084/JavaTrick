package bj.jakeChen.Guava;

import com.google.common.primitives.Ints;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestIntCompare {

	public static void main( String[] args ) {

		int compare = Ints.compare( 1, 2 );
		System.out.println("Ints.compare -> " + compare);

		compare = Ints.compare( 1, 1 );
		System.out.println("Ints.compare -> " + compare);

		compare = Ints.compare( 2, 1 );
		System.out.println("Ints.compare -> " + compare);
	}

}
