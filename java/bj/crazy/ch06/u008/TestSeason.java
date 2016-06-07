package bj.crazy.ch06.u008;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestSeason {

	public TestSeason( Season s ) {

		System.out.println( s.getName() + "，这真是一个" +
		                    s.getDesc() + "的季节" );

	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 直接使用Season的FALL常量代表一个Season对象

		new TestSeason( Season.FALL );

	}

}
