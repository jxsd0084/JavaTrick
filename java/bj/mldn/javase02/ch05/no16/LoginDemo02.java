package bj.mldn.javase02.ch05.no16;

class Check {        // 完成具体的验证操作

	public boolean validate( String name, String password ) {

		if ( name.equals( "lixinghua" ) && password.equals( "mldn" ) ) {        // 验证
			return true;
		} else {
			return false;
		}
	}
}

// 本类只是调用具体的验证的操作
class Operate {

	private String info[];        // 定义一个数组属性，用于接收全部输入参数

	public Operate( String info[] ) {

		this.info = info;        // 通过构造方法取得全部的输入参数
	}

	public String login() {

		Check check = new Check();                   // 实例化Check对象，用于检查信息
		this.isExit();                               // 判断输入的参数是否正确

		String str      = null;                      // 用于返回信息
		String name     = this.info[ 0 ];            // 取出姓名
		String password = this.info[ 1 ];            // 取出密码


		if ( check.validate( name, password ) ) {    // 登陆验证
			str = "欢迎" + name + "光临！";
		} else {
			str = "错误的用户名和密码！";
		}
		return str;
	}

	// 判断参数个数，来决定是否退出程序
	public void isExit() {
		if ( this.info.length != 2 ) {
			System.out.println( "输入的参数不正确，系统退出！" );    // 给出一个正确的格式
			System.out.println( "格式：java LoginDemo02 用户名 密码" );
			System.exit( 1 );                      // 系统退出
		}
	}
};

public class LoginDemo02 {

	public static void main( String args[] ) {

		Operate oper = new Operate( args );        // 实例化操作类的对象
		System.out.println( oper.login() );        // 取得验证之后的信息
	}

}
