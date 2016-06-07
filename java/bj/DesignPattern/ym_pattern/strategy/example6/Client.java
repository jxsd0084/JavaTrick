package bj.DesignPattern.ym_pattern.strategy.example6;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		LogContext log = new LogContext();
		log.log( "记录日志" );
		log.log( "再次记录日志" );

	}

}
