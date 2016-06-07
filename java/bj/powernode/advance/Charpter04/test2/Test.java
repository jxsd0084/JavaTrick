package bj.powernode.advance.Charpter04.test2;

public class Test {

	// 向上就近匹配原则
	public void add( int i, int j ) {

		System.out.println( "int参数的方法被调用" );
	}

	public void add( long i, long j ) {

		System.out.println( "long参数的方法被调用" );
	}

	public void add( byte i, byte j ) {

		System.out.println( "byte参数的方法被调用" );
	}

	public void add( short i, short j ) {

		System.out.println( "short参数的方法被调用" );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		byte b1 = 12;
		byte b2 = 20;

		Test test = new Test();
		test.add( b1, b2 );
	}

}
