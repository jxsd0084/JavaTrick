package bj.mldn.DAO.org.lxh.oracle.dao.proxy;

import bj.mldn.DAO.org.lxh.oracle.dao.IEmpDAO;
import bj.mldn.DAO.org.lxh.oracle.dao.impl.IEmpDAOImpl;
import bj.mldn.DAO.org.lxh.oracle.dbc.DataBaseConnection;
import bj.mldn.DAO.org.lxh.oracle.vo.Emp;

import java.util.List;

public class IEmpDAOProxy implements IEmpDAO {

	private DataBaseConnection dbc   = null;
	private IEmpDAO            dao   = null;
	private int                count = 0;

	public IEmpDAOProxy() {

		this.dbc = new DataBaseConnection();        // 在代理类中完成数据库连接对象的实例化
		this.dao = new IEmpDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Emp emp) throws Exception {

		boolean flag = false;
		try {
			if (this.dao.findById(emp.getEmpno()) == null) {
				flag = this.dao.doCreate(emp);      // 调用真实主题实现类
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doDelete(int empno) throws Exception {

		boolean flag = false;
		try {
			flag = this.dao.doDelete(empno);        // 调用真实主题实现类
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Emp emp) throws Exception {

		boolean flag = false;
		try {
			flag = this.dao.doUpdate(emp);            // 调用真实主题实现类
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List findAll(int currentPage, int lineSize, String keyWord)
			throws Exception {

		List all = null;
		try {
			all = this.dao.findAll(currentPage, lineSize, keyWord);
			this.count = this.dao.getAllCount(keyWord);    // 查全部记录的时候把全部的记录数也查出来
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Emp findById(int empno) throws Exception {

		Emp emp = null;
		try {
			emp = this.dao.findById(empno);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return emp;
	}

	public int getAllCount(String keyWord) throws Exception {

		return this.count;
	}

}
