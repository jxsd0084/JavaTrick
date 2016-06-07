package bj.mldn.javase02.ch17.no04;

public class ConnectionDemo01 {

	// 定义MySQL的数据库驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		try {
			Class.forName( DBDRIVER );    // 加载驱动程序
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
}
