package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo12 {

	public static void main( String args[] ) {

		String str    = "hello";                       // 定义字符串
		String newStr = str.replaceAll( "l", "x" );    // 现在将所有的l替换成x
		System.out.println( "替换之后的结果：" + newStr );
	}

}
