package bj.DesignPattern.JavaPattern._26_状态模式.section3;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         模拟电梯的动作
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Context context = new Context();
		context.setLiftState( new ClosingState() );

		context.open();
		context.close();
		context.run();
		context.stop();
		context.open();

	}

}
