package threads.JavaThreadCookBook.ch04_线程安全的集合类._6_Vector;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Administrator on 2016/6/4.
 */
public class VectorTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 如果不添加泛型声明的话, 后面foreach遍历的时候就需要先判断类型, 然后做强制类型转换的
		Vector< Integer > vector = new Vector< Integer >();
		vector.add( 1 );
		vector.add( 2 );
		vector.add( 3 );
		vector.add( 4 );
		vector.add( 5 );

		for ( Integer i : vector ) {

			System.out.println( "-> " + i.intValue() );
		}

		Vector< String > vector2 = new Vector< String >();
		vector2.addElement( "one" );
		vector2.addElement( "two" );
		vector2.addElement( "three" );

		vector2.removeElement( "two" );
		if ( vector2.contains( "three" ) ) {
			Iterator< String > iterator = vector2.iterator();
			while ( iterator.hasNext() ) {

				System.out.println( iterator.next() );
			}
		}

	}
	
}
