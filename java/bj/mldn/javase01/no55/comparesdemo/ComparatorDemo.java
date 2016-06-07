package bj.mldn.javase01.no55.comparesdemo;

import java.util.Arrays;

public class ComparatorDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student stu[] = {
				new Student( 1, "张三", 21, 99.1f ),
				new Student( 2, "李四", 20, 99.1f ),
				new Student( 3, "王五", 21, 89.1f ),
				new Student( 4, "赵六", 21, 80.1f ),
				new Student( 5, "孙七", 19, 80.1f )
		};

		System.out.println( "============== 数组声明之前 ===============" );

		print( stu );

		System.out.println( "============== 数组排序之后 ===============" );

		Arrays.sort( stu, new StudentComparator() );// 排序

		print( stu );

	}

	public static void print( Student stu[] ) {

		for ( int i = 0; i < stu.length; i++ ) {

			System.out.println( stu[ i ] );
		}
	}
}
