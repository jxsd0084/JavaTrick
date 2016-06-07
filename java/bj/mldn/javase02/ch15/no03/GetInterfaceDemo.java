package bj.mldn.javase02.ch15.no03;

public class GetInterfaceDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Class< ? > c1 = null;        // 声明Class对象
		try {
			c1 = Class.forName( "org.lxh.demo15.Person" );    // 实例化对象
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		Class< ? > c[] = c1.getInterfaces();    // 以数组形式返回实现的全部接口
		for ( int i = 0; i < c.length; i++ ) {
			System.out.println( "实现的接口名称：" + c[ i ].getName() );    // 输出接口名称
		}
	}
}
