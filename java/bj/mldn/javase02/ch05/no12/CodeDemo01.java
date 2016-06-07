package bj.mldn.javase02.ch05.no12;

public class CodeDemo01 {

	public static void main( String args[] ) {

		{                   // 普通代码块
			int x = 30;     // 就属于一个局部变量
			System.out.println( "普通代码块 --> x = " + x );
		}

		int x = 100;        // 与局部变量名称相同
		System.out.println( "代码块之外 --> x = " + x );
	}

}
