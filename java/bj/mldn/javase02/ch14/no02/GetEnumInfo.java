package bj.mldn.javase02.ch14.no02;

public class GetEnumInfo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color c : Color.values() ) {
			System.out.println( c.ordinal() + " --> " + c.name() );
		}
	}
}
