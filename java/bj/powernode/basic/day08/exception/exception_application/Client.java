package bj.powernode.basic.day08.exception.exception_application;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			UserService us = new UserService();

			us.register( "jack" );

		} catch ( IllegalNameException e ) {

			System.out.println( e.getMessage() );

		}


	}
}
