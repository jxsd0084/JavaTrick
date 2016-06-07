package bj.mldn.javase02.ch14.no02;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

enum Color2 {
	RED, GREEN, BLUE;
}

public class ComparableEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Set< Color2 > t = new TreeSet< Color2 >();    // 设置类型
		t.add( Color2.GREEN );    // 加入绿色
		t.add( Color2.RED );        // 加入红色
		t.add( Color2.BLUE );        // 加入蓝色
		Iterator< Color2 > iter = t.iterator();
		while ( iter.hasNext() ) {
			System.out.print( iter.next() + "、" );
		}
	}
}
