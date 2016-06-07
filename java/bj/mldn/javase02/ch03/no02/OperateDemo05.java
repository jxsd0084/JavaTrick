package bj.mldn.javase02.ch03.no02;

public class OperateDemo05 {

	public static void main( String args[] ) {

		if ( 5 > 2 ) {
			System.out.println( "条件成立：5大于2" );
		}

		if ( true ) {
			System.out.println( "直接写的true" );
		}

		if ( ( 3 + 6 ) == ( 3 - 6 ) ) {
			System.out.println( "这是不可能成立的！" );
		}
	}

}
