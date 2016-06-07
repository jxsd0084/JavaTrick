/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch13_Java安全.ch13_3_Java单项加密._353;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 使用Hmac加密
 */
public class SingleHmacServerFile {

	static String algorithm = "HmacMD5";

	static String keyFile = "keyData.dat";

	/**
	 * 生成密钥
	 *
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public void initMacKey() throws NoSuchAlgorithmException {

		KeyGenerator generator = KeyGenerator.getInstance( algorithm );
		SecretKey    key       = generator.generateKey();

		writeFile( key.getEncoded(), keyFile );
	}

	/**
	 * HMAC加密
	 *
	 * @param data
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public byte[] encryptHMAC( byte[] data ) throws NoSuchAlgorithmException,
			InvalidKeyException {

		byte      key[]     = readFile( keyFile );
		SecretKey secretKey = new SecretKeySpec( key, algorithm );
		Mac       mac       = Mac.getInstance( secretKey.getAlgorithm() );
		mac.init( secretKey );
		return mac.doFinal();

	}

	/**
	 * 把数据写到指定的文件上
	 *
	 * @param data     数据
	 * @param fileName 文件名称
	 */
	public void writeFile( byte[] data, String fileName ) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream( fileName );
			fileOutputStream.write( data );
			fileOutputStream.close();
		} catch ( FileNotFoundException e2 ) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据fileName读取数据文件
	 *
	 * @param fileName
	 * @return
	 */
	public byte[] readFile( String fileName ) {

		// 读取
		try {
			File            file            = new File( fileName );
			FileInputStream fileInputStream = new FileInputStream( file );
			byte[]          data            = new byte[ (int) file.length() ];
			fileInputStream.read( data );
			fileInputStream.close();
			return data;
		} catch ( FileNotFoundException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 测试
	 *
	 * @param avg
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static void main( String[] avg ) throws NoSuchAlgorithmException, InvalidKeyException {

		SingleHmacServerFile singleHmacServerFile = new SingleHmacServerFile();
		SingleHmacClientFile singleHmacClientFile = new SingleHmacClientFile();
		String               data                 = "明日科技";
		System.out.println( "加密前：" + data );
		String strData       = null;
		String strDataClient = null;

		singleHmacServerFile.initMacKey();
		strData = BothBase64.encryptBASE64( singleHmacServerFile.encryptHMAC( data.getBytes() ) );
		strDataClient = BothBase64.encryptBASE64( singleHmacClientFile.encryptHMAC( data.getBytes() ) );

		System.out.println( "服务端加密后：" + strData );
		System.out.println( "客户端加密后：" + strDataClient );
		if ( strData.equals( strDataClient ) ) {
			System.out.println( "验证通过" );
		} else {
			System.out.println( "验证不通过" );
		}
	}
}
