package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._180_高效的枚举元素映射;

import java.util.EnumMap;

/**
 * 高效的枚举元素映射
 */
public class EnumMapTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		EnumMap< Weeks, String > weeks = new EnumMap< Weeks, String >( Weeks.class );
		weeks.put( Weeks.MONDAY, "星期一" );
		weeks.put( Weeks.SUNDAY, "星期日" );

		System.out.println( "EnumMap中的键值对个数：" + weeks.size() );
		System.out.println( "EnumMap中的键值对：" + weeks );
		System.out.println( "EnumMap中是否包含键SATURADAY："
		                    + weeks.containsKey( Weeks.SATURADAY ) );
		System.out.println( "EnumMap中是否包含值星期日：" + weeks.containsValue( "星期日" ) );

		weeks.remove( Weeks.MONDAY );

		System.out.println( "EnumMap中的键值对：" + weeks );
		System.out.println( "EnumMap中键MONDAY对应的值：" + weeks.get( Weeks.MONDAY ) );

	}

}
