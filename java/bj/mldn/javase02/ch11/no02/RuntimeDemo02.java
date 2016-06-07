package bj.mldn.javase02.ch11.no02;

public class RuntimeDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Runtime run = Runtime.getRuntime();    // 取得Runtime类的实例化对象
		try {
			run.exec( "notepad.exe" );         // 调用本机程序，此方法需要异常处理
		} catch ( Exception e ) {
			e.printStackTrace();               // 打印异常信息
			// System.out.println(e) ;
		}
	}
}
