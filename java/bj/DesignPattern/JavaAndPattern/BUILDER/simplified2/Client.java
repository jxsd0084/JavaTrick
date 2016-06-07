package bj.DesignPattern.JavaAndPattern.BUILDER.simplified2;

public class Client {

	private static Builder builder;

	/**
	 * 测试
	 * @param args
	 */
	static public void main( String[] args ) {
		builder = new Builder();
		builder.construct();

		Product product = builder.retrieveResult();

		//continue here
	}

}
