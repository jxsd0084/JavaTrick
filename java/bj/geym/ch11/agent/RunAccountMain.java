package bj.geym.ch11.agent;

import bj.geym.ch11.aop.timestat.Account;

/**
 * -javaagent d:/ja.jar
 * <p>
 * -javaagent:d:/jat.jar=argument
 *
 * @author Administrator
 */
public class RunAccountMain {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Account account = new Account();
		account.operation();
	}
}
