package bj.powernode.advance.Charpter18.src.dao;

import bj.powernode.advance.Charpter18.src.domain.Users;
import bj.powernode.advance.Charpter18.src.exception.MyException;
import bj.powernode.advance.Charpter18.src.util.JdbcUtil;

import java.io.IOException;
import java.sql.*;

/**
 * dao包下面的类主要是用来获取数据库信息的
 * <p>
 * UsersDao类用来获取数据库中的用户表的,包括:用户名和密码
 */

// dao data access objec
// 在dao中完成JDBC的操作
// 在DAO中,把捕获的异常包装成一个运行时异常,传递给调用者
// 在Web开发中,底层的异常一定要报告给服务器才可以(使用运行时异常进行报告)
// Dao中的每个方法,只能包装一个单独的SQL语句!,是为了增强代码的复用性

public class UsersDao {

	// 校验用户的方法,返回boolean类型,参数:Users类型 user
	public boolean validataUsers( Users user ) {

		boolean result = false;

		Connection        conn  = null;
		PreparedStatement pstat = null;
		ResultSet         res   = null;

		try {
			conn = JdbcUtil.getConnection();

			// 准备一条sql语句
			String sql = "SELECT * FROM USERS WHERE UPPER(NAME)=UPPER(?) and password=?";
			pstat = conn.prepareStatement( sql );
			pstat.setString( 1, user.getName() );
			pstat.setString( 2, user.getPassword() );

			res = pstat.executeQuery();
			if ( res.next() ) {
				result = true;
			}
		} catch ( SQLException e ) {
			throw new MyException( e );
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( IOException e ) {
			throw new MyException( e );

			// 最后关闭数据库
		} finally {
			JdbcUtil.closeDb( res, pstat, conn );
		}

		// 返回result变量
		return result;
	}
}
