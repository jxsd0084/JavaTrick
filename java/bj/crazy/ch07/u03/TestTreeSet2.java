package bj.crazy.ch07.u03;

import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class D implements Comparable {

	int count;

	public D( int count ) {

		this.count = count;
	}

	public String toString() {

		return "R(count属性:" + count + ")";
	}

	public boolean equals( Object obj ) {

		if ( obj instanceof D ) {

			D d = (D) obj;

			if ( d.count == this.count ) {

				return true;
			}
		}

		return false;
	}

	public int compareTo( Object obj ) {

		D d = (D) obj;
		if ( this.count > d.count ) {
			return 1;

		} else if ( this.count == d.count ) {
			return 0;

		} else {
			return - 1;

		}
	}
}

public class TestTreeSet2 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		TreeSet ts = new TreeSet();

		ts.add( new D( 5 ) );
		ts.add( new D( - 3 ) );
		ts.add( new D( 9 ) );
		ts.add( new D( - 2 ) );




		// 打印TreeSet集合，集合元素是有序排列的
		System.out.println( ts );




		// 取出第一个元素
		D first = (D) ts.first();

		// 为第一个元素的count属性赋值
		first.count = 20;



		// 取出最后一个元素
		D last = (D) ts.last();

		// 为最后一个元素的count属性赋值，与倒数第二个元素count属性相同
		last.count = - 2;

		// 再次输出count将看到TreeSet里的元素处于无序状态，且有重复元素
		System.out.println( ts );

		// 删除属性被改变的元素，删除失败
		ts.remove( new D( - 2 ) );

		System.out.println( ts );

		// 删除属性没有改变的元素，删除成功
		ts.remove( new D( 5 ) );

		System.out.println( ts );

	}

}
