package bj.mldn.DAO.org.lxh.oracle.dao.impl;

import bj.mldn.DAO.org.lxh.oracle.dao.IEmpDAO;
import bj.mldn.DAO.org.lxh.oracle.vo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IEmpDAOImpl implements IEmpDAO {

	private Connection conn = null; // 如果要想完成数据库操作则肯定需要数据库连接对象

	public IEmpDAOImpl(Connection conn) {

		this.conn = conn;           // 由外部实例化时传递连接
	}

	public boolean doCreate(Emp emp) throws Exception {

		boolean           flag  = false;
		PreparedStatement pstmt = null;
		String            sql   = "INSERT INTO emp(empno,ename,job,hiredate,sal,comm,photo) VALUES (?,?,?,?,?,?,?)";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
			pstmt.setFloat(5, emp.getSal());
			pstmt.setFloat(6, emp.getComm());
			pstmt.setString(7, emp.getPhoto());
			int count = pstmt.executeUpdate(); // 执行更新，返回更新的记录数
			if (count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}

	public boolean doDelete(int empno) throws Exception {

		boolean           flag  = false;
		PreparedStatement pstmt = null;
		String            sql   = "DELETE FROM emp WHERE empno=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int count = pstmt.executeUpdate(); // 执行更新，返回更新的记录数
			if (count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}

	public boolean doUpdate(Emp emp) throws Exception {

		boolean           flag  = false;
		PreparedStatement pstmt = null;
		String            sql   = "UPDATE emp SET ename=?,job=?,hiredate=?,sal=?,comm=?,photo=? WHERE empno=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setDate(3, new java.sql.Date(emp.getHiredate().getTime()));
			pstmt.setFloat(4, emp.getSal());
			pstmt.setFloat(5, emp.getComm());
			pstmt.setString(6, emp.getPhoto());
			pstmt.setInt(7, emp.getEmpno());
			int count = pstmt.executeUpdate(); // 执行更新，返回更新的记录数
			if (count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return flag;
	}

	public List findAll(int currentPage, int lineSize, String keyWord)
			throws Exception {

		List              allEmp = new ArrayList();
		PreparedStatement pstmt  = null;
		String sql = "SELECT temp.* FROM "
		             + "(SELECT empno,ename,job,hiredate,sal,comm,photo,ROWNUM rn "
		             + " FROM emp "
		             + " WHERE (empno LIKE upper(?) OR ename LIKE upper(?) OR job LIKE upper(?) "
		             + "OR to_char(hiredate,'yyyy') LIKE upper(?) OR to_char(hiredate,'mm') LIKE upper(?)"
		             + " OR to_char(hiredate,'dd') LIKE upper(?) OR sal LIKE upper(?) OR comm LIKE upper(?)) "
		             + " AND ROWNUM<=" + (currentPage * lineSize)
		             + ") temp WHERE temp.rn>" + (currentPage - 1) * lineSize;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord + "%");
			pstmt.setString(2, "%" + keyWord + "%");
			pstmt.setString(3, "%" + keyWord + "%");
			pstmt.setString(4, "%" + keyWord + "%");
			pstmt.setString(5, "%" + keyWord + "%");
			pstmt.setString(6, "%" + keyWord + "%");
			pstmt.setString(7, "%" + keyWord + "%");
			pstmt.setString(8, "%" + keyWord + "%");
			ResultSet rs  = pstmt.executeQuery();
			Emp       emp = null;
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setHiredate(rs.getDate(4));
				emp.setSal(rs.getFloat(5));
				emp.setComm(rs.getFloat(6));
				emp.setPhoto(rs.getString(7));
				allEmp.add(emp);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return allEmp;
	}

	public Emp findById(int empno) throws Exception {

		Emp               emp   = null;
		PreparedStatement pstmt = null;
		String            sql   = "SELECT empno,ename,job,hiredate,sal,comm,photo FROM emp WHERE empno=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 表示已经查找到了
				emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setHiredate(rs.getDate(4));
				emp.setSal(rs.getFloat(5));
				emp.setComm(rs.getFloat(6));
				emp.setPhoto(rs.getString(7));
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return emp;
	}

	public int getAllCount(String keyWord) throws Exception {

		int               count = 0;
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(empno) FROM emp "
		             + " WHERE empno LIKE upper(?) OR ename LIKE upper(?) OR job LIKE upper(?) "
		             + " OR to_char(hiredate,'yyyy') LIKE upper(?) OR to_char(hiredate,'mm') LIKE upper(?) "
		             + " OR to_char(hiredate,'dd') LIKE upper(?) OR sal LIKE upper(?) OR comm LIKE upper(?)";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord + "%");
			pstmt.setString(2, "%" + keyWord + "%");
			pstmt.setString(3, "%" + keyWord + "%");
			pstmt.setString(4, "%" + keyWord + "%");
			pstmt.setString(5, "%" + keyWord + "%");
			pstmt.setString(6, "%" + keyWord + "%");
			pstmt.setString(7, "%" + keyWord + "%");
			pstmt.setString(8, "%" + keyWord + "%");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 表示已经查找到了
				count = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return count;
	}

}
