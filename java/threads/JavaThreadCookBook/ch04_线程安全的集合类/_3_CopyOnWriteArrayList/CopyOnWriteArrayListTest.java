package threads.JavaThreadCookBook.ch04_线程安全的集合类._3_CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2016/6/4.
 */
public class CopyOnWriteArrayListTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		CopyOnWriteArrayList< Integer > list = new CopyOnWriteArrayList< Integer >();
		list.add( 0 );
		list.add( 1 );
		list.add( 2 );
		list.add( 3 );
		list.add( 4 );

		for ( Integer i : list ) {

			System.out.println( "-> " + i );
		}

		CopyOnWriteArrayList< String > list2 = new CopyOnWriteArrayList<>();
		list2.add( "one" );
		list2.add( "three" );
		list2.add( 1, "two" );
		System.out.println( list2.get( 1 ) );
		if ( list2.contains( "three" ) ) {
			Iterator< String > iterator = list2.iterator();
			while ( iterator.hasNext() ) {

				System.out.println( iterator.next() );
			}
		}

	}
	
}

/*

	CopyOnWriteArrayList中的set、add、remove等方法, 都使用了ReentrantLock的Lock()来加锁, unlock()来解锁.

当增加元素的时候使用Arrays.copyOf()来拷贝副本, 在副本上增加元素, 然后改变原引用指向副本.

读操作不需要解锁, 而写操作进行了加锁.

	因此, CopyOnWriteArrayList类是一个线程安全的List接口实现, 这对读操作远远多于写操作的应用非常适合.

特别是在并发情况下, 可以提供高性能的并发读取, 并保证读取的内容一定是正确的, 不受多线程并发问题影响的.



 */
