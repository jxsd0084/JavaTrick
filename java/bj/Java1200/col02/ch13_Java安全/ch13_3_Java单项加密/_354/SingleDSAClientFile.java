/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch13_Java安全.ch13_3_Java单项加密._354;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * 使用DSA加密
 */
public class SingleDSAClientFile {

	static String algorithm = "DSA";

	static String signdataFile  = "fileSignData.dat";
	static String publickeyFile = "keyPublicData.dat";

	/**
	 * 用数字签名进行验证
	 *
	 * @param data
	 * @return
	 */
	public boolean verifySign( byte[] data ) {

		byte[] key  = readFile( publickeyFile );
		byte[] sign = readFile( signdataFile );

		X509EncodedKeySpec keySpec    = new X509EncodedKeySpec( key );
		KeyFactory         keyFactory = null;
		PublicKey          publicKey  = null;

		try {
			// 获取公钥匙
			keyFactory = KeyFactory.getInstance( algorithm );
			publicKey = keyFactory.generatePublic( keySpec );
		} catch ( InvalidKeySpecException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( NoSuchAlgorithmException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// 验证数字签名
			Signature signature = Signature.getInstance( keyFactory
					                                             .getAlgorithm() );
			signature.initVerify( publicKey );
			signature.update( data );
			return signature.verify( sign );
		} catch ( NoSuchAlgorithmException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( InvalidKeyException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( SignatureException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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

}
