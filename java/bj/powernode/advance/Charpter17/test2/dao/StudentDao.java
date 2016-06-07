package bj.powernode.advance.Charpter17.test2.dao;

import bj.powernode.advance.Charpter17.test1.JdbcUtil;
import bj.powernode.advance.Charpter17.test2.domain.Student;

import java.sql.*;

public class StudentDao {

	public void insertStu( Student stu ) {

		Connection        conn  = null;
		CallableStatement cstat = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "{call insert_stu(?,?,?)}";
			cstat = conn.prepareCall( sql );

			cstat.setString( 1, stu.getName() );
			cstat.setInt( 2, stu.getAge() );
			cstat.setString( 3, stu.getSex() );

			cstat.execute();

			System.out.println( "调用存储过程成功!" );

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( null, cstat, conn );
		}
	}

	public void testProcParam() {

		Connection        conn  = null;
		CallableStatement cstat = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "{call proc_test(?,?,?)}";
			cstat = conn.prepareCall( sql );

			cstat.setString( 1, "in类型数据的原始值" );
			cstat.setString( 3, "IN OUT类型的原始值" );
			cstat.registerOutParameter( 2, Types.VARCHAR );
			cstat.registerOutParameter( 3, Types.VARCHAR );

			cstat.execute();

			String s1 = cstat.getString( 2 );
			String s2 = cstat.getString( 3 );

			System.out.println( "调用存储过程成功!  " + s1 + "  " + s2 );

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( null, cstat, conn );
		}
	}

}
