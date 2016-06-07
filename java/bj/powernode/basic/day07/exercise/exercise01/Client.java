package bj.powernode.basic.day07.exercise.exercise01;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		YAMAHA y = new YAMAHA();
		HONDA  h = new HONDA();

		//测试引擎
		Car c = new Car(); //买了一个汽车

		c.testEngine( y ); //汽车安装了 YAMAHA

		c.testEngine( h ); //汽车安装了 HONDA

	}

}
