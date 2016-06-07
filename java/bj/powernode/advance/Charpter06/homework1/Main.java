package bj.powernode.advance.Charpter06.homework1;

public class Main {

	/*

	   4. 在现实生活中，我买了一辆车（提示：main中新建了一个汽车类），
	   然后我首先把一个YAMAHA的发动机装在了我的汽车上(提示：新建了
	   一个YAMAHA对象，),然后测试一下发动机(提示:调用testEngine())。
	   然后我发现我不喜欢YAMAHA的发动机，于是我换了一个HONDA的发动机， 然后重新测试一下。

	 */

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 多态,用IEngine创建Yahama对象
		IEngine y = new Yamaha();



		// 多态,用IEngine创建Honda对象
		IEngine h = new Honda();



		// 创建Car类对象
		Car car = new Car();

		// 调用Car类中的testEngine方法
		car.testEngine( y );
		car.testEngine( h );


	}

}
