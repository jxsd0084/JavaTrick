package bj.czbk.day11;
/*


单例设计模式。


*/

//  饿汉式。
/*
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}
*/


//  懒汉式
class Single {

	private static Single s = null;

	private Single() {

	}


	public static Single getInstance() {

		if ( s == null ) {
			synchronized ( Single.class ) {
				if ( s == null )
				//  --->A;
				{
					s = new Single();
				}
			}
		}
		return s;
	}
}

class SingleDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "Hello World!" );
	}
}
