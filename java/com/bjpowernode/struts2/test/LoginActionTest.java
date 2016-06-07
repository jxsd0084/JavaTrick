package com.bjpowernode.struts2.test;

import com.bjpowernode.struts2.action.LoginAction;

public class LoginActionTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		LoginAction loginAction = new LoginAction();
		loginAction.setUsername( "admin" );
		//loginAction.setPassword("admin");
		loginAction.setPassword( "asdfsdf" );

		String retVal = loginAction.execute();
		System.out.println( retVal );

	}

}
