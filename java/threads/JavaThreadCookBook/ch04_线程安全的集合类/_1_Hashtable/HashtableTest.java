package threads.JavaThreadCookBook.ch04_线程安全的集合类._1_Hashtable;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/4.
 */
public class HashtableTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		Hashtable table = new Hashtable();
		table.put( "0", 0 );
		table.put( "1", 1 );
		table.put( "2", 2 );
		table.put( "3", 3 );
		table.put( "4", 4 );

		Set      set      = table.entrySet();
		Iterator iterator = set.iterator();
		while ( iterator.hasNext() ) {

			System.out.println( "-> " + iterator.next() );
		}

		Hashtable< String, Integer > table2 = new Hashtable<>();
		table2.put( "one", 1 );
		table2.put( "two", 2 );
		table2.put( "three", 3 );

		Integer n = table2.get( "two" );
		if ( n != null ) {

			System.out.println( "two = " + n );
		}

	}
	
}

/*

ArrayList       -> 数组
Vector          -> 数组 + synchronized
HashMap
Hashtable       -> HashMap + synchronized
哈希表           -> 链表网 + 哈希函数, 跟 数组 没有什么关系.
LinkedHashMap   -> 链表
HashSet         -> HashMap
LinkedHashSet   -> LinkedHashMap
TreeSet         -> TreeMap

*/
