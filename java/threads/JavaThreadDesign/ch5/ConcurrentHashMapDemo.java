package threads.JavaThreadDesign.ch5;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) {

		ConcurrentHashMap map = new ConcurrentHashMap();

		map.put( "a", "aa" );

	}

}

/*

HashMap与ConcurrentHashMap的区别

URL:    http://blog.csdn.net/xuefeng0707/article/details/40834595


从ConcurrentHashMap代码中可以看出，

它引入了一个“分段锁”的概念，

具体可以理解为把一个大的Map拆分成N个小的HashTable，

根据key.hashCode()来决定把key放到哪个HashTable中。

*/
