package bj.powernode.advance.Charpter17.test3;

import bj.powernode.advance.Charpter17.test1.JdbcUtil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class ConnectionPool implements DataSource {

	// 连接池的初始化容量是10个
	private int          maxSize = 10;
	private int          index   = maxSize - 1;
	private Connection[] conns   = new Connection[ maxSize ];

	// -----------------------------------------------------------
	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {

	}

	public static ConnectionPool getConnectionPool() {

		return instance;
	}

	// -----------------------------------------------------------

	{
		for ( int i = 0; i < maxSize; i++ ) {
			conns[ i ] = JdbcUtil.getConnection();
		}
	}

	public Connection getConnection() throws SQLException {

		Connection conn = conns[ index ];
		conns[ index ] = null;
		index--;
		return conn;
	}

	public void returnConn( Connection conn ) {

		index++;
		conns[ index ] = conn;
	}

	/**
	 * 取得连接池中可以使用的链接的数量
	 *
	 * @return
	 */
	public int getUseableConn() {

		return index + 1;
	}

	@Override
	public Connection getConnection( String username, String password )
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {

		return null;
	}

	@Override
	public void setLogWriter( PrintWriter out ) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout( int seconds ) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor( Class< ? > iface ) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public < T > T unwrap( Class< T > iface ) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
