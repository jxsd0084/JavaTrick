package bj.mldn.DAO.org.lxh.oracle.dao;

import bj.mldn.DAO.org.lxh.oracle.vo.Emp;

import java.util.List;

public interface IEmpDAO {

	public boolean doCreate( Emp emp ) throws Exception;

	public boolean doUpdate( Emp emp ) throws Exception;

	public boolean doDelete( int empno ) throws Exception;

	public Emp findById( int empno ) throws Exception;

	public List findAll( int currentPage, int lineSize, String keyWord ) throws Exception;

	public int getAllCount( String keyWord ) throws Exception;

}
