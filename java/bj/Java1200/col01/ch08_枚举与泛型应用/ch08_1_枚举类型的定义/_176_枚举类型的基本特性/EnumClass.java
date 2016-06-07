package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._176_枚举类型的基本特性;

/**
 * 枚举类型的基本特征
 */
public class EnumClass {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		for ( Size size : Size.values() ) {
			System.out.println( size + "的序数是：" + size.ordinal() );
			System.out.print( size.compareTo( Size.SMALL ) + " " );
			System.out.print( size.equals( Size.SMALL ) + " " );
			System.out.println( size == Size.SMALL );
			System.out.println( size.name() );
			System.out.println( "********************" );
		}

	}
}
