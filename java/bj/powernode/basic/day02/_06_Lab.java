package bj.powernode.basic.day02;

public class _06_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  测试if语句

		boolean flag = false;

		if ( flag ) {

			System.out.println( "flag=" + flag );
		}


		if ( ! flag ) {

			System.out.println( "flag is false." );
		}







		boolean isSuccess = true;

		//  只有一句语句需要执行的时候,{}可以省略
		if ( isSuccess ) {

			System.out.println( "恭喜你,成功了." );
		}






		boolean isCommit = false;
		if ( isCommit ) {

			System.out.println( "提交了." );
		}

		System.out.println( "执行了." );


		//  注意:if语句其中一个分支执行,则if语句执行结束.
		if ( isCommit ) {
			System.out.println( "提交了" );

		} else {
			System.out.println( "没提交." );

		}







		int i = 190;

		if ( i < 100 ) {
			System.out.println( i + "小于100" );

		} else if ( i < 120 ) {
			System.out.println( i + "小于120" );

		} else if ( i < 160 ) {
			System.out.println( i + "小于160" );

		} else {
			System.out.println( i + "大于等于160" );

		}


	}

}
