package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._179_高效的枚举元素集合;

import java.util.EnumSet;

/**
 * 高效的枚举元素集合
 */
public class EnumSetTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		EnumSet< Weeks > week = EnumSet.noneOf( Weeks.class );
		week.add( Weeks.MONDAY );
		System.out.println( "EnumSet中的元素：" + week );
		week.remove( Weeks.MONDAY );
		System.out.println( "EnumSet中的元素：" + week );
		week.addAll( EnumSet.complementOf( week ) );
		System.out.println( "EnumSet中的元素：" + week );
		week.removeAll( EnumSet.range( Weeks.MONDAY, Weeks.THURSDAY ) );
		System.out.println( "EnumSet中的元素：" + week );
	}

}
