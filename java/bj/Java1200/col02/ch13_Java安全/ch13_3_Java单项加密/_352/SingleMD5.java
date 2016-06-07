/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch13_Java安全.ch13_3_Java单项加密._352;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用MD5加密
 */
public class SingleMD5 {

	static String algorithm = "MD5";

	/**
	 * MD5加密，返回byte[]类型
	 *
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] encryptMD5( byte[] data )
			throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance( algorithm );
		digest.update( data );
		return digest.digest();
	}

	/**
	 * 把MD5加密数据转换String类型
	 *
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptMD5toString( byte[] data )
			throws NoSuchAlgorithmException {

		String str = "";
		String str16;
		System.out.println( data.length );
		for ( int i = 0; i < data.length; i++ ) {
			str16 = Integer.toHexString( 0xFF & data[ i ] );
			if ( str16.length() == 1 ) {
				str = str + "0" + str16;
			} else {
				str = str + str16;
			}

		}
		return str;
	}

	/**
	 * 测试
	 *
	 * @param avg
	 */
	public static void main( String[] avg ) {

		String data = "明日科技";
		System.out.println( "加密前：" + data );
		byte[] data1 = null;
		String str   = null;
		try {
			data1 = SingleMD5.encryptMD5( data.getBytes() );
			str = SingleMD5.encryptMD5toString( data1 );
		} catch ( NoSuchAlgorithmException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "加密后byte[]类型：" + new String( data1 ) );
		System.out.println( "加密后String类型：" + str );

	}

}
