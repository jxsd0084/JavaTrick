package bj.jakeChen.Guava;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestJoiner {

	public static void main( String[] args ) {

		int[]  numbers         = { 1, 2, 3, 4, 5 };
		String numbersAsString = Joiner.on( ";" ).join( Ints.asList( numbers ) );
		System.out.println( "Joiner.on -> " + numbersAsString );

		String numbersAsStringDirectly = Ints.join( ";", numbers );
		System.out.println( "Ints.join -> " + numbersAsStringDirectly );

	}

}
