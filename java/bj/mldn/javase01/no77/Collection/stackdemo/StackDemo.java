package bj.mldn.javase01.no77.Collection.stackdemo;

import java.util.Stack;

public class StackDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Stack< String > s = new Stack< String >();
		s.push( "A" );
		s.push( "B" );
		s.push( "C" );
		System.out.println( s.pop() );
		System.out.println( s.pop() );
		System.out.println( s.pop() );
		System.out.println( s.pop() );    // 栈已经没有内容
	}

}
