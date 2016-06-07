package bj.powernode.basic.day09;

/*

	String类的常用方法.

*/
public class TestString01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 1.常用的构造方法.
		String s1 = "hello";

		String s2 = new String( "hello" );

		String s3 = new String();                   // 空的字符序列


		char[] chars = { 'a', 'b', 'c', 'd', 'e' };
		String s4    = new String( chars );         // abcde
		String s5    = new String( chars, 2, 3 );   // cde
		System.out.println( "s4=" + s4 );
		System.out.println( "s5=" + s5 );



		// 2.常用的方法






		// 2.1 charAt
		String s6 = "abcdef";
		char   c1 = s6.charAt( 1 ); //索引从0开始
		System.out.println( "c1=" + c1 );






		// 2.2 compareTo方法.比较两个字符串在字典中的先后顺序
		System.out.println( "abc".compareTo( "def" ) );  // abc字符串在字典中的顺序比def字符串靠前.返回一个负整数
		System.out.println( "abc".compareTo( "abc" ) );  // 返回0
		System.out.println( "def".compareTo( "abc" ) );  // def字符串在字典中的顺序比abc字符串靠后.返回一个正整数




		// 2.3 compareToIgnoreCase  忽略大小写
		System.out.println( "abc".compareToIgnoreCase( "ABC" ) );



		// 2.4 concat 字符串连接 等同于+
		System.out.println( "abc".concat( "def" ) );




		// 2.5 contains 判断某个字符串是否包含某个字符串
		boolean isContains = "中华人民共和国".contains( "人民" );
		System.out.println( isContains ); //true





		// 2.6 endsWith 判断某个字符串是否以某个字符串结尾
		System.out.println( "abcdef!".endsWith( "def" ) ); // false
		System.out.println( "welcome dlpowernode study java!".endsWith( "ava!" ) );  //true





		// 2.7 equals 判断两个字符串内容是否一致.
		String s7  = new String( "hello" );
		String s8  = new String( "hello" );
		String s9  = "hello";
		String s10 = "hello";

		System.out.println( s7 == s8 );         // false
		System.out.println( s7.equals( s8 ) );  // true
		System.out.println( s9 == s10 );        // true





		// 2.8 equalsIgnoreCase 忽略大小写
		System.out.println( "Abc".equalsIgnoreCase( "ABc" ) );  // true





		// 2.9 indexOf 返回指定子字符串在此字符串中第一次出现处的索引
		int index1 = "abcdef".indexOf( "cde" );
		System.out.println( index1 ); //2

		System.out.println( "abcdef".indexOf( 97 ) );  //0
		System.out.println( "abcdef".indexOf( 'd' ) ); //3





		// 2.10 lastIndexOf 返回指定子字符串在此字符串中最右边出现处的索引
		System.out.println( "corejavasunjavagoodjava".lastIndexOf( "java" ) ); // 19





		// 2.11 length 返回此字符的长度
		System.out.println( " abc def ".length() );  // 9





		// 2.12 replace
		String s11 = "ajavacjavadjavasunjavagoodjava";
		String s12 = s11.replace( "java", "c++" );
		System.out.println( s12 );                          // ac++ cc++ dc++ sunc++ goodc++





		// 2.13 startsWith
		System.out.println( "abcdef".startsWith( "abc" ) );  // true





		// 2.14 substring
		System.out.println( "abcdef".substring( 1 ) );      // bcdef
		System.out.println( "abcdef".substring( 2, 4 ) );   // cd  不包含4






		// 2.15 toLowerCase toUpperCase
		System.out.println( "ABCDEf".toLowerCase() );       // abcdef
		System.out.println( "abcDEf".toUpperCase() );       // ABCDEF





		// 2.16 trim 截掉字符串的前后空白.
		System.out.print( "       a   b   c    d   ".trim() );  // a   b   c    d
		System.out.println( "hello" );





		// 2.17 valueOf 将参数转换成对应的字符串
		int    i   = 10;
		String s13 = i + "";
		String s14 = String.valueOf( i );
		System.out.println( s14 + 10 );         // 1010

		String s15 = "100";
		int    i1  = Integer.parseInt( s15 );   // 100
		System.out.println( i1 + 100 );         // 200






		// 2.18 分割字符串
		String[] strs = "abc,def,jhi,java,c++,oracle,mysql".split( "," );
		for ( int j = 0; j < strs.length; j++ ) {

			System.out.println( strs[ j ] );
		}


	}

}
