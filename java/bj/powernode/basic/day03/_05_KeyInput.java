package bj.powernode.basic.day03;

public class _05_KeyInput {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "欢迎使用学生管理系统" );

		//  如果用java程序接收键盘输入的数据?

		java.util.Scanner scanner = new java.util.Scanner( System.in );


		System.out.print( "请输入学生的成绩：" );


		int score = scanner.nextInt();  //  程序执行到此处时，处于等待状态，等待用户键盘的输入.


		//  System.out.println("用户在键盘上输入的数据是=" + score);


		System.out.println( "学生的成绩是：" + score );


	}

}
