package threads.JavaThreadCookBook.ch04_线程安全的集合类._2_ConcurrentHashMap;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/6/4.
 */
public class ConcurrentHashMapTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		ConcurrentHashMap< String, Integer > map = new ConcurrentHashMap< String, Integer >();
		map.put( "0", 0 );
		map.put( "1", 1 );
		map.put( "2", 2 );
		map.put( "3", 3 );
		map.put( "4", 4 );

		for ( Map.Entry< String, Integer > entry : map.entrySet() ) {

			System.out.println( "-> " + entry );
		}

		ConcurrentHashMap< String, Integer > map2 = new ConcurrentHashMap< String, Integer >();
		map2.put( "one", 1 );
		map2.put( "two", 2 );
		map2.put( "three", 3 );
		System.out.println( map2.get( "two" ) );
		if ( map2.contains( "one" ) && "1".equals( map2.get( "two" ) ) ) {

			map2.remove( "one" );
		}
		for ( Map.Entry< String, Integer > entry : map2.entrySet() ) {

			System.out.println( "-> " + entry );
		}

	}
	
}

/*

HashMap与ConcurrentHashMap的区别:

http://blog.csdn.net/xuefeng0707/article/details/40834595

从JDK1.2起，就有了HashMap，正如前一篇文章所说，HashMap不是线程安全的，因此多线程操作时需要格外小心。

在JDK1.5中，伟大的Doug Lea给我们带来了concurrent包，从此Map也有安全的了。

ConcurrentHashMap具体是怎么实现线程安全的呢，肯定不可能是每个方法加synchronized，那样就变成了HashTable。

从ConcurrentHashMap代码中可以看出，它引入了一个“分段锁”(Segment)的概念，

具体可以理解为把一个大的Map拆分成N个小的HashTable，根据key.hashCode()来决定把key放到哪个HashTable中。


*/
