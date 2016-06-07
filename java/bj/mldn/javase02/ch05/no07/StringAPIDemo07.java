package bj.mldn.javase02.ch05.no07;

public class StringAPIDemo07 {

	public static void main( String args[] ) {

		String str1 = "hello world";                    // 定义字符串
		System.out.println( str1.substring( 6 ) );      // 从第7个位置开始截取
		System.out.println( str1.substring( 0, 5 ) );   // 截取0~5个位置的内容
	}

}
