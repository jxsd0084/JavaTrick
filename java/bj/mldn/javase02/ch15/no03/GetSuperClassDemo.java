package bj.mldn.javase02.ch15.no03;

public class GetSuperClassDemo {

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
		Class< ? > c2 = c1.getSuperclass();    // 取得父类
		System.out.println( "父类名称：" + c2.getName() );
	}
}
