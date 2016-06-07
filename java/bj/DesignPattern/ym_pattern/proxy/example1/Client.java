package bj.DesignPattern.ym_pattern.proxy.example1;

import java.util.*;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		UserManager             userManager = new UserManager();

		Collection< UserModel > col         = userManager.getUserByDepId( "0101" );

		System.out.println( col );

	}

}
