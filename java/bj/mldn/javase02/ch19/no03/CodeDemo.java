package bj.mldn.javase02.ch19.no03;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeDemo {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {

		String keyWord = "李兴华";
		String encod   = URLEncoder.encode( keyWord, "UTF-8" );    // 进行编码的操作
		System.out.println( "编码之后的内容：" + encod );
		String decod = URLDecoder.decode( encod, "UTF-8" );        // 进行解码操作
		System.out.println( "解码之后的内容：" + decod );
	}
}
