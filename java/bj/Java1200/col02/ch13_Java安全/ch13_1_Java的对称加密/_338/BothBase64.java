/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch13_Java安全.ch13_1_Java的对称加密._338;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * 使用BASE64解密
 */
public class BothBase64 {

	/**
	 * 加密
	 *
	 * @param data
	 * @return
	 */
	public static String encryptBASE64( byte[] data ) {
		//加密数据
		return ( new BASE64Encoder() ).encodeBuffer( data );
	}

	/**
	 * 解密
	 *
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static byte[] decryptBASE64( String data ) throws IOException {
		//解密数据
		return ( new BASE64Decoder() ).decodeBuffer( data );
	}

	/**
	 * 测试
	 *
	 * @param avg
	 * @throws IOException
	 */
	public static void main( String[] avg ) throws IOException {

		String data = "明日科技";
		System.out.println( "加密前：" + data );
		String data1 = BothBase64.encryptBASE64( data.getBytes() );
		System.out.println( "加密后：" + data1 );
		byte[] data2 = BothBase64.decryptBASE64( data1 );
		System.out.println( "解密后：" + new String( data2 ) );

	}

}
