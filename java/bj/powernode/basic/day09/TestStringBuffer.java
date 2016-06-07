package bj.powernode.basic.day09;

/*

	StringBuffer:缓冲区对象.它不是字符串.
	
	StringBuffer不是String.
	
	默认初始化容量是: 16

*/
public class TestStringBuffer {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		//1.构造方法
		StringBuffer sb1 = new StringBuffer();          // 初始化容量是16

		StringBuffer sb2 = new StringBuffer( "hello world" );

		StringBuffer sb3 = new StringBuffer( 20 );      // 初始化容量是 20





		// 2.常用的方法.


		// 2.1 取出Buffer中的字符串.
		String s1 = sb2.toString();
		System.out.println( s1 );






		// 2.2 append 追加  注意：重载
		StringBuffer sb4 = sb2.append( " hello world2" );
		System.out.println( sb4.toString() );

		StringBuffer sb5 = sb4.append( true );
		System.out.println( sb5.toString() );

		StringBuffer sb6 = sb5.append( 100 );
		System.out.println( sb6.toString() );






		// 2.3 delete
		System.out.println( sb2.delete( 2, 4 ).toString() );    // heo world hello world2true100






		// 2.4 deleteCharAt
		System.out.println( sb2.deleteCharAt( 4 ).toString() ); // heo orld hello world2true100






		// 2.5 insert
		System.out.println( sb2.insert( 2, "sunjava" ) );       // hesunjavao orld hello world2true100






		// 2.6 reverse
		System.out.println( sb2.reverse().toString() );






	}

}
