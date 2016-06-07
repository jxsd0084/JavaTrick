package threads.JavaThreadCookBook.ch04_线程安全的集合类._4_CopyOnWriteArraySet;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Administrator on 2016/6/4.
 */
public class CopyOnWriteArraySetTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		CopyOnWriteArraySet< Integer > set = new CopyOnWriteArraySet< Integer >();
		set.add( 0 );
		set.add( 1 );
		set.add( 2 );
		set.add( 3 );
		set.add( 4 );
		set.add( 5 );

		for ( Integer i : set ) {

			System.out.println( "-> " + i );
		}

		CopyOnWriteArraySet< String > set2 = new CopyOnWriteArraySet<>();
		set2.add( "one" );
		set2.add( "two" );
		set2.add( "three" );
		if ( set2.contains( "three" ) ) {
			Iterator< String > iterator = set2.iterator();
			while ( iterator.hasNext() ) {

				System.out.println( iterator.next() );
			}
		}

	}

}
