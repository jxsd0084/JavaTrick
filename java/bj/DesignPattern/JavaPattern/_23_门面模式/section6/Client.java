package bj.DesignPattern.JavaPattern._23_门面模式.section6;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Facade facade = new Facade();

		facade.methodA();
		facade.methodB();
		facade.methodC();

	}

}
