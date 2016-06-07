package bj.DesignPattern.JavaAndPattern.factorymethod.QUERY;

import java.sql.ResultSet;

public class Client {

	/**
	 * @directed
	 * @link aggregation
	 */
	private static QueryRunner runner;

	public static void main( String[] args )
			throws Exception {
		runner = new SybaseQueryRunner();

		ResultSet rs = runner.run();
	}

}
