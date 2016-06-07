package bj.JavaSpecialForces.chapter01;

public class IntAndTest {

	public static void test() {
		int a = 1, b = 1, c = 1, d = 1;

		a++;
		++b;

		c = c++;
		d = ++d;

		System.out.println( a + "\t" + b + "\t" + c + "\t" + d );
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		test();

	}

}
