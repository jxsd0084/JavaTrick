package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._178_选择合适的枚举元素;

/**
 * 选择合适的枚举元素
 */
public enum JDBCInfo {
	DRIVER, URL, USERNAME, PASSWORD;

	public String getJDBCInfo( JDBCInfo info ) {

		switch ( info ) {
			case DRIVER:
				return "com.mysql.jdbc.Driver";
			case URL:
				return "jdbc:mysql://localhost:3306/db_database";
			case USERNAME:
				return "mr";
			case PASSWORD:
				return "mingrisoft";
			default:
				return null;
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		for ( JDBCInfo info : JDBCInfo.values() ) {

			System.out.println( info + ":" + info.getJDBCInfo( info ) );
		}
	}

}
