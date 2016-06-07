package bj.powernode.advance.Charpter10.test1;

public class TestString {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 在Java中只有使用了""格式来创建字符串对象,该对象在String池中分配
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hello";

		System.out.println( s1 == s2 );






		String s4 = "Hello";
		// 一个输出的是hashCode数值,另一个输出的是字符数	
		System.out.println( s1.hashCode() + "  " + s4.length() );

		String s5 = "World";
		s5 = s2 + s1;
		System.out.println( s5.hashCode() + "   " + s5.length() );






		String s6 = new String( "Hello" );
		String s7 = new String( "Hello" );

		System.out.println( s6 == s7 );
		System.out.println( s6.equals( s7 ) );






		String s8 = "Hello";
		String s9 = "Hello";
		System.out.println( s8 == s9 );




		String s10 = new String( "Hello" );
		System.out.println( equal( s10 ) );





		String s11 = "Hello";
		char   c  = s11.charAt( 0 );
		System.out.println( c );
		String s12 = "Hello.jsp";
		System.out.println( s12.endsWith( ".jsp" ) );





		String s13 = "Hello";
		s13 = s13.concat( "World" );
		System.out.println( s13 );




		String s14 = "";
		System.out.println( s14.isEmpty() + "         " + s14.length() );





		String s15     = "wusz@163.com";
		int    index = s15.indexOf( "@" );

		if ( s15.endsWith( ".com" ) ||
		     s15.equals( ".gov" ) ||
		     s15.endsWith( ".net" ) ) {
			System.out.println( "有效的域名" );
		}

		System.out.println( index );





		String s16    = "Hello@World";
		int    index2 = s16.indexOf( "@" );
		String s17     = s16.substring( index2 + 1 );
		System.out.println( s17 );





		String   s18  = "dsjf/kld/sjf/jls/kfjd/sljf/dls";
		String[] arr = s18.split( "/" );
		for ( String s : arr ) {

			System.out.println( s );
		}






		String s19 = "    He   llo        ";

		s19 = s19.trim();
		System.out.println(s19.length() + "=" + s19);

		s19 = s19.replace( " ", "" );
		System.out.println( s19.length() + "=" + s19 );






		String s20 = "   TMD, 你们真好!";
		if ( s20.indexOf( "TMD" ) != - 1 ) {
			s20 = s20.replace( "TMD", "NND" );
		}
		System.out.println( s20 );





		int    i = 10;

		String s21 = String.valueOf( i ); // "10"
		String s22 = "Hello" + "World";
		String       s23    = "Hello";


		StringBuffer strb1 = new StringBuffer( s23 );
		StringBuffer strb2 = strb1.append( "Java" ).append( "Oracle" ).append(
				"Oracle" ).append( "Html" );

		System.out.println( ( strb1 == strb2 ) + "    " +
		                    strb1.hashCode() + "  " +
		                    strb2.hashCode() );

		String s24 = strb2.toString();





	}


	public static boolean equal( String s ) {

		if ( "Hello".equals( s ) ) {
			return true;

		} else {
			return false;
		}

	}

}
