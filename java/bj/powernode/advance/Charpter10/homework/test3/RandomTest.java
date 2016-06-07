package bj.powernode.advance.Charpter10.homework.test3;

import java.util.Random;

public class RandomTest {

	private static String[] stus = { "王学良", "李飞", "杨炼", "武剑" };

	public static int getRandom( int length ) {

		return new Random().nextInt( length );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "请" + stus[ getRandom( stus.length ) ] + " 同学回答问题" );
	}

}
