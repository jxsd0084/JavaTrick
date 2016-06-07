package bj.powernode.basic.day12.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 0.创建比较器
		Comparator userComparator = new UserComparator();




		// 1.创建集合
		SortedSet users = new TreeSet( userComparator ); // 传递比较器





		// 2.准备用户对象
		User u1 = new User( "jack", 10 );
		User u2 = new User( "jack", 20 );
		User u3 = new User( "jack", 30 );
		User u4 = new User( "jack", 40 );
		User u5 = new User( "jack", 50 );





		// 3.添加对象
		users.add( u5 );
		users.add( u1 );
		users.add( u4 );
		users.add( u3 );
		users.add( u2 );





		// 4.遍历集合
		Iterator it = users.iterator();
		while ( it.hasNext() ) {

			System.out.println( it.next() );
		}

	}

}
