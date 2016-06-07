package bj.DesignPattern.sxt_pattern.proxy.staticProxy;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Star real = new RealStar();

		Star proxy = new ProxyStar( real );

		proxy.confer();

		proxy.signContract();

		proxy.bookTicket();

		proxy.sing();

		proxy.collectMoney();

	}

}
