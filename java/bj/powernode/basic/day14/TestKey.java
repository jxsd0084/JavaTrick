package bj.powernode.basic.day14;

/*

	模拟键盘输入 (in)
	老方法: Scanner.

*/

import java.io.*;

public class TestKey {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		String userInput = "";

		while ( true ) {

			userInput = br.readLine();


			// BUG
			/*
				if(userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("bye")){
					break;
				}
			*/

			// 防止空指针异常 NullPointerException
			if ( "exit".equalsIgnoreCase( userInput ) ) {

				break;
			}

			System.out.println( "您输入了：" + userInput );
		}


		br.close();

	}

}
