package bj.powernode.advance.Charpter17.test3;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {

	public static DataSource getDataSource() throws SQLException {
		// OracleConnectionPoolDataSource dataSource = new
		// OracleConnectionPoolDataSource();
		// dataSource.setURL("jdbc:oracle:thin:@192.168.1.11:1521:bjpowernode");
		// dataSource.setUser("scott");
		// dataSource.setPassword("tiger");
		// return dataSource;

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName( "oracle.jdbc.OracleDriver" );
		dataSource.setUrl( "jdbc:oracle:thin:@192.168.1.11:1521:bjpowernode" );
		dataSource.setUsername( "scott" );
		dataSource.setPassword( "tiger" );

		// dataSource.getInitialSize()
		return dataSource;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		try {

			DataSource      ds  = getDataSource();
			BasicDataSource bds = (BasicDataSource) ds;
			bds.setInitialSize( 10 );

			Connection conn = bds.getConnection();

			System.out.println( conn + "  " + bds.getInitialSize() + " " );

		} catch ( SQLException e ) {

			e.printStackTrace();
		}
	}

}
