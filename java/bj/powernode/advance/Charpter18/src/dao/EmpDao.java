package bj.powernode.advance.Charpter18.src.dao;

import bj.powernode.advance.Charpter18.src.domain.Emp;
import bj.powernode.advance.Charpter18.src.exception.MyException;
import bj.powernode.advance.Charpter18.src.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * EmpDao类是用来获取数据库中emp表信息的
 * <p>
 * 包含一个插入emp表的方法:insertEmp,返回boolean类型的值,参数:Emp类型 emp
 */

public class EmpDao {

	// 对emp表插入数据的方法,返回boolean类型,抛出SQL异常
	public boolean insertEmp( Emp emp ) throws SQLException {

		boolean result = false;

		Connection        conn  = null;
		PreparedStatement pstat = null;

		try {

			conn = JdbcUtil.getConnection();
			// String sql =
			// "INSERT INTO EMP VALUES (8000,'张三','工程师',7698, '12-12月-1987',3000.0,2000.0,30)";

			// 准备一条插入数据库表的sql操作语句
			String sql = "INSERT INTO EMP VALUES (?,      ? ,    ? ,?   , ?,             ?,    ?,      ?)";
			pstat = conn.prepareStatement( sql );

			// 设置emp表中给个字段的
			pstat.setInt( 1, emp.getEmpno() );
			pstat.setString( 2, emp.getEname() );
			pstat.setString( 3, emp.getJob() );
			pstat.setInt( 4, emp.getMgr() );
			pstat.setDate( 5, emp.getHiredate() );
			pstat.setDouble( 6, emp.getSal() );
			pstat.setDouble( 7, emp.getComm() );
			pstat.setInt( 8, emp.getDeptno() );

			// 执行数据库表内容更新的语句
			int res = pstat.executeUpdate();
			if ( res > 0 ) {
				result = true;
			}

			// 以下抛出的是自定义异常
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( SQLException e ) {
			// 注意这里抛出异常的方式有些不一样!!
			throw e;
		} catch ( IOException e ) {
			throw new MyException( e );

			// 最后要把与数据库的连接给全部关闭到
		} finally {
			JdbcUtil.closeDb( null, pstat, conn );
		}

		// 最后返回result变量
		return result;
	}
}
