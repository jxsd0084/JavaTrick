package bj.JavaSpecialForces.chapter03.oom;

public class StackOverFlowTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		new StackOverFlowTest().testStackOver();
	}

	public void testStackOver() {
		testStackOver();
	}

}
