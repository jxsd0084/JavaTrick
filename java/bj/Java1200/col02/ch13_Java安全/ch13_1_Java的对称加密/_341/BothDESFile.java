/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch13_Java安全.ch13_1_Java的对称加密._341;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * 使用DES解密
 */
public class BothDESFile {

	String algorithm = "DES";
	// key保存的文件名称
	String keyFile   = "keyData.dat";
	// 数据保存的文件名称
	String dataFile  = "fileData.dat";

	public BothDESFile() {

		try {
			initKey();
		} catch ( NoSuchAlgorithmException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成密钥数据,保存到文件中
	 *
	 * @throws NoSuchAlgorithmException
	 */
	private void initKey() throws NoSuchAlgorithmException {
		// 产生一个随机数源
		SecureRandom secureRandom = new SecureRandom();
		// 为DES算法生成一个KeyGenerator
		KeyGenerator generator = KeyGenerator.getInstance( algorithm );
		generator.init( secureRandom );
		SecretKey key = generator.generateKey();
		//生成密钥数据,保存到文件中
		writeFile( key.getEncoded(), keyFile );

	}

	/**
	 * 转化密钥成Key进行加密解密
	 *
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private Key toKey() throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException {

		byte[]           key       = readFile( keyFile );
		DESKeySpec       keySpec   = new DESKeySpec( key );
		SecretKeyFactory factory   = SecretKeyFactory.getInstance( algorithm );
		SecretKey        secretKey = factory.generateSecret( keySpec );
		return secretKey;
	}

	/**
	 * 加密，把加密数据保存在文件中
	 *
	 * @param data
	 * @param key
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public void encrypt( byte[] data ) throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {

		Key key = toKey();
		// 使用Cipher实际完成加密操作
		Cipher cipher = Cipher.getInstance( algorithm );
		// 使用密钥初始化Cipher
		cipher.init( Cipher.ENCRYPT_MODE, key );
		byte[] f = cipher.doFinal( data );
		writeFile( f, dataFile );
	}

	/**
	 * 解密把数据从文件中取出来在解密
	 *
	 * @param data
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypt() throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {

		Key    key    = toKey();
		Cipher cipher = Cipher.getInstance( algorithm );
		cipher.init( Cipher.DECRYPT_MODE, key );
		byte[] f = readFile( dataFile );
		return new String( cipher.doFinal( f ) );
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
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static void main( String[] avg ) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		BothDESFile bothDESFile = new BothDESFile();
		String      data        = "明日科技";

		// 数据加密
		System.out.println( "加密前：" + data );
		bothDESFile.encrypt( data.getBytes() );

		// 数据解密
		String b = bothDESFile.decrypt();
		System.out.println( "解密后：" + b );

	}
}
