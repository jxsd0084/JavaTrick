package bj.bigData.Impala.TestImpala;

import java.sql.*;

class ClouderaJDBCImpalaExample {

	static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";

	private static final String CONNECTION_URL = "jdbc:impala://172.31.107.11:21050";

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Connection        con       = null;
		ResultSet         rs        = null;
		PreparedStatement prep      = null;
		String            prepQuery = "SELECT * FROM default.student_info";
		try {
			Class.forName( JDBC_DRIVER );
			con = DriverManager.getConnection( CONNECTION_URL );
			prep = con.prepareStatement( prepQuery );
			prep.execute();
			rs = prep.getResultSet();
			while ( rs.next() ) {
				String city = rs.getString( "city" );
				String col1 = rs.getString( "col1" );
				String col2 = rs.getString( "col2" );
				System.out.printf( "%20s%20s%20s\r\n", city, col1,
						col2 );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
			} catch ( SQLException se1 ) {
			}
			try {
				if ( prep != null ) {
					prep.close();
				}
			} catch ( SQLException se3 ) {
			}
			try {
				if ( con != null ) {
					con.close();
				}
			} catch ( SQLException se4 ) {
			}
		}
	}
}