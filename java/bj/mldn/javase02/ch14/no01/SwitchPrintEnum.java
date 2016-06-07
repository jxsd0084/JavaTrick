package bj.mldn.javase02.ch14.no01;

public class SwitchPrintEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color c : Color.values() ) {    // 输出枚举中的全部内容
			print( c );
		}
	}

	public static void print( Color color ) {

		switch ( color ) {
			case RED: {
				System.out.println( "红颜色" );
				break;
			}
			case GREEN: {
				System.out.println( "绿颜色" );
				break;
			}
			case BLUE: {
				System.out.println( "蓝颜色" );
				break;
			}
			default: {
				System.out.println( "未知颜色" );
				break;
			}
		}
	}
}
