package bj.czbk.day10;

/*
	finally代码块：定义一定执行的代码。
	通常用于关闭资源。
*/
class FuShuException extends Exception {

	FuShuException( String msg ) {

		super( msg );
	}
}

class Demo5 {

	int div( int a, int b ) throws FuShuException {

		if ( b < 0 ) {
			throw new FuShuException( "除数为负数" );
		}
		return a / b;
	}
}

class ExceptionDemo5 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Demo5 d = new Demo5();

		try {
			int x = d.div( 4, - 1 );
			System.out.println( "x=" + x );

		} catch ( FuShuException e ) {
			System.out.println( e.toString() );
			return;
			//  System.exit(0);//系统，退出。jvm结束。
		} finally {
			System.out.println( "finally" );//finally中存放的是一定会被执行的代码。
		}

		System.out.println( "over" );
	}
}


class NoException extends Exception {

}

	/*
	public void method() throws NoException {

		连接数据库;

		数据操作;        //  throw new SQLException();

		关闭数据库;      //  该动作，无论数据操作是否成功，一定要关闭资源。

		try {

			连接数据库;

			数据操作;    //  throw new SQLException();
		} catch (SQLException e) {
			会对数据库进行异常处理;
			throw new NoException();

		} finally {
			关闭数据库;
		}
	}
	*/
