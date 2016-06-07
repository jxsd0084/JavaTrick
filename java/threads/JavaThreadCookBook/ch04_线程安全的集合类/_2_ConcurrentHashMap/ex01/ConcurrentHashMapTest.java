package threads.JavaThreadCookBook.ch04_线程安全的集合类._2_ConcurrentHashMap.ex01;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/6/4.
 */
public class ConcurrentHashMapTest {

	private static ConcurrentHashMap< Integer, Integer > map = new ConcurrentHashMap< Integer, Integer >();

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		new Thread( "Thread1" ) {
			@Override
			public void run() {

				map.put( 3, 33 );
			}
		}.start();

		new Thread( "Thread2" ) {
			@Override
			public void run() {

				map.put( 4, 44 );
			}
		}.start();

		new Thread( "Thread3" ) {
			@Override
			public void run() {

				map.put( 7, 77 );
			}
		}.start();

		System.out.println( map );

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
