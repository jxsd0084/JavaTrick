package bj.Java1200.col01.ch17_文件与文件夹操作.ch17_2_文件与数据库._420;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper implements DBConfig {

	private static Connection conn;
	private static Statement  stat;
	private static ResultSet  rs;

	public static Connection getConnection() {

		try {
			Class.forName( DRIVER );
			conn = DriverManager.getConnection( URL, USERNAME, PASSWORD );
			return conn;
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static Statement openStatement() {

		try {
			stat = getConnection().createStatement();
			return stat;
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static int update( String sql ) {

		int result = 0;
		try {
			result = openStatement().executeUpdate( sql );
			return result;
		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public static List< Object[] > query( String sql ) {

		List< Object[] > result = new ArrayList< Object[] >();
		try {
			rs = openStatement().executeQuery( sql );
			String[] columnNames = getColumnNames( sql );
			Object[] columnContent;
			while ( rs.next() ) {
				columnContent = new Object[ columnNames.length ];
				for ( int i = 0; i < columnNames.length; i++ ) {
					columnContent[ i ] = rs.getObject( columnNames[ i ] );
				}
				result.add( columnContent );
			}
			return result;
		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public static List< Object > getTableNames() {

		List< Object > list = new ArrayList< Object >();
		try {
			DatabaseMetaData dmd = getConnection().getMetaData();
			rs = dmd.getTables( null, null, null, new String[]{ "TABLE" } );
			while ( rs.next() ) {
				list.add( rs.getString( 3 ) );
			}
			return list;
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return list;
	}

	public static String[] getColumnNames( String sql ) {

		String[] columnNames = null;
		try {
			rs = getConnection().createStatement().executeQuery( sql );
			ResultSetMetaData data        = rs.getMetaData();
			int               columnCount = data.getColumnCount();
			columnNames = new String[ columnCount ];
			for ( int i = 0; i < columnNames.length; i++ ) {
				columnNames[ i ] = data.getColumnName( i + 1 );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return columnNames;
	}

	private static void close() {

		if ( rs != null ) {
			try {
				rs.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
		if ( stat != null ) {
			try {
				stat.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
		if ( conn != null ) {
			try {
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}
}
