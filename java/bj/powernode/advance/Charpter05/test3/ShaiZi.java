package bj.powernode.advance.Charpter05.test3;

import java.util.Random;

public class ShaiZi {

	private static ShaiZi instance1 = new ShaiZi();
	private static ShaiZi instance2 = new ShaiZi();

	private ShaiZi() {

	}

	public static ShaiZi getInstance1() {

		return instance1;
	}

	public static ShaiZi getInstance2() {

		return instance2;
	}

	/**
	 * 色子摇的方法,
	 *
	 * @return 返回1-6之间的随机数
	 */
	public int yao() {

		Random r = new Random();
		return r.nextInt( 6 ) + 1;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		ShaiZi sz1 = ShaiZi.getInstance1();
		ShaiZi sz2 = ShaiZi.getInstance2();

		System.out.println( sz1.yao() + "  " + sz2.yao() );
	}

}
