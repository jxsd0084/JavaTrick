package bj.bigData.HBase.ex03.common.utils;

/**
 * IDC系统相关的公共方法
 *
 * @author ranhualin
 * @date 2013-7-22
 */
public class IDCUtils {

	/**
	 * 对k进行hash,转换hash结果为8位byte数组返回
	 *
	 * @param k
	 * @return
	 */
	public static byte[] stringHashToBytes( final String k ) {

		int temp = k.hashCode();
		if ( temp < 0 ) {
			temp = temp + Integer.MAX_VALUE;
		}
		byte[] b = new byte[ 8 ];
		for ( int i = b.length - 1; i >= 0; i-- ) {
			b[ i ] = ( byte ) ( ( temp % 10 ) + '0' );
			temp /= 10;
		}
		return b;
	}
//	public static void main(String[] args) {
//		stringHashToBytes("111.161.46.140");
//	}

	/**
	 * 反转byte数组
	 *
	 * @param in
	 * @return
	 */
	public static byte[] invers( byte[] in ) {

		byte[] out = new byte[ in.length ];
		for ( int i = in.length - 1; i >= 0; i-- ) {
			out[ in.length - 1 - i ] = in[ i ];
		}
		return out;
	}

	/**
	 * 返回长度为length的数组，如果in的长度小于length则前面填充def 如果in的长度大于length，则截取in的后面部分
	 *
	 * @param in
	 * @param length
	 * @param def
	 * @return
	 */
	public static byte[] subRight( byte[] in, int length, byte def ) {

		return ByteUtils.fillStarts( in, length, def );
	}

	/**
	 * 返回长度为length的数组，如果in的长度小于length则后面填充def 如果in的长度大于length，则截取in的前面部分
	 *
	 * @param in
	 * @param length
	 * @param def
	 * @return
	 */
	public static byte[] subLeft( byte[] in, int length, byte def ) {

		return ByteUtils.fillEnds( in, length, def );
	}

}
