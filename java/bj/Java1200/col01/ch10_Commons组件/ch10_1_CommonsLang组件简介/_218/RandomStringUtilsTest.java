package bj.Java1200.col01.ch10_Commons组件.ch10_1_CommonsLang组件简介._218;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 生成随机字符串
 */
public class RandomStringUtilsTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "生成长度为5的由字母组成的字符串" );
		String randomString = RandomStringUtils.randomAlphabetic( 5 ); // 获得随机字符串
		System.out.println( randomString );

		System.out.println( "生成长度为5的由字母和数字组成的字符串" );
		randomString = RandomStringUtils.randomAlphanumeric( 5 ); // 获得随机字符串
		System.out.println( randomString );

		System.out.println( "生成长度为5的由ASCII编码在32~126间字符组成的字符串" );
		randomString = RandomStringUtils.randomAscii( 5 ); // 获得随机字符串
		System.out.println( randomString );

		System.out.println( "生成长度为5的由数字组成的字符串" );
		randomString = RandomStringUtils.randomNumeric( 5 ); // 获得随机字符串
		System.out.println( randomString );

	}

}
