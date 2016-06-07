package bj.powernode.basic.day06.userlogin;

import java.util.Scanner;


//  客户端接收用户输入的用户名和密码

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//  1.接收用户的输入

		System.out.println( "欢迎使用用户管理系统" );

		System.out.println( "请您先登录." );

		System.out.print( "请输入用户名：" );

		Scanner s = new Scanner( System.in );

		String username = s.next();     // 接收用户名

		System.out.print( "请输入密码：" );

		String password = s.next();     //  接收密码


		//  2.创建UserService对象
		UserService us = new UserService();

		boolean isSuccess = us.login( username, password );


		//  3.判断isSuccess是true/false
		if ( isSuccess ) {  //  登录成功
			System.out.println( "登录成功，欢迎[" + username + "]回来." );

		} else {            //  登录失败
			System.out.println( "登录失败，用户名[" + username + "]不存在或密码错误." );
		}


	}

}
