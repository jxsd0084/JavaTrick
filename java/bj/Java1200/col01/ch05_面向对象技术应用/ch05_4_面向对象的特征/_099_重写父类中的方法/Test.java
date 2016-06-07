package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._099_重写父类中的方法;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Employee employee = new Employee();
		System.out.println( employee.getInfo() );

		Manager manager = new Manager();
		System.out.println( manager.getInfo() );

	}

}
