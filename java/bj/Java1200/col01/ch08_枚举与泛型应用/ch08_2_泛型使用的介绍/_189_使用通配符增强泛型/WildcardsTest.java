package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._189_使用通配符增强泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用通配符增强泛型
 */
public class WildcardsTest {

	public static Object getMiddle( List< ? extends Number > list ) {

		return list.get( list.size() / 2 );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		List< Integer > ints = new ArrayList< Integer >();
		ints.add( 1 );
		ints.add( 2 );
		ints.add( 3 );

		System.out.print( "整型列表的元素：" );
		System.out.println( Arrays.toString( ints.toArray() ) );
		System.out.println( "整型列表的中间数：" + getMiddle( ints ) );

		List< Double > doubles = new ArrayList< Double >();
		doubles.add( 1.1 );
		doubles.add( 2.2 );
		doubles.add( 3.3 );

		System.out.print( "浮点列表的元素：" );
		System.out.println( Arrays.toString( doubles.toArray() ) );
		System.out.println( "浮点列表的中间数：" + getMiddle( doubles ) );

	}

}
