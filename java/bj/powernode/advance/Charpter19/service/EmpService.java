package bj.powernode.advance.Charpter19.service;

import bj.powernode.advance.Charpter19.dao.EmpDao;
import bj.powernode.advance.Charpter19.domain.Emp;
import bj.powernode.advance.Charpter19.domain.EmpPage;
import bj.powernode.advance.Charpter19.exception.MyException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmpService {

	public EmpPage page( Emp emp, int currentPage ) throws SQLException {

		EmpPage page = new EmpPage();
		// 1.调用dao的取得总条数的方法
		// 2.调用DAO的取得分页数据的方法
		// 3.封装PageBean

		EmpDao      ed       = new EmpDao();
		int         totalNum = 0;
		List< Emp > list     = null;
		try {
			totalNum = ed.getTotalNum( emp );
			list = ed.searchPageEmp( emp, currentPage );
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( SQLException e ) {
			throw e;
		} catch ( IOException e ) {
			throw new MyException( e );
		}

		page.setCurrentPage( currentPage );
		page.setList( list );
		page.setTotalNum( totalNum );

		return page;
	}
}
