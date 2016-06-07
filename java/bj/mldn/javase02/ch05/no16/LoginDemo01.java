package bj.mldn.javase02.ch05.no16;

public class LoginDemo01 {

	public static void main( String args[] ) {

		if ( args.length != 2 ) {           // 应该判断输入的参数个数是否是2
			System.out.println( "输入的参数不正确，系统退出！" );    // 给出一个正确的格式
			System.out.println( "格式：java LoginDemo01 用户名 密码" );
			System.exit( 1 );               // 系统退出
		}

		String name     = args[ 0 ];        // 取出用户名
		String password = args[ 1 ];        // 取出密码


		if ( name.equals( "lixinghua" ) && password.equals( "mldn" ) ) {    // 验证
			System.out.println( "欢迎" + name + "光临！" );
		} else {
			System.out.println( "错误的用户名和密码！" );
		}
	}

}
