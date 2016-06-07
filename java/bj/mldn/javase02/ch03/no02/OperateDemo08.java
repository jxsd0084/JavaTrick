package bj.mldn.javase02.ch03.no02;

public class OperateDemo08 {

	public static void main( String args[] ) {

		int score = 50;    // 定义成绩
		if ( ( score < 0 ) || ( score > 100 ) ) {
			System.out.println( "输入的成绩有错误！" );
		}
		if ( ( score < 60 ) && ( score > 49 ) ) {
			System.out.println( "成绩不及格，准备补考吧！" );
		}
	}
}
