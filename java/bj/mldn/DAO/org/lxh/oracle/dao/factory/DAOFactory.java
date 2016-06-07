package bj.mldn.DAO.org.lxh.oracle.dao.factory;

import bj.mldn.DAO.org.lxh.oracle.dao.IEmpDAO;
import bj.mldn.DAO.org.lxh.oracle.dao.proxy.IEmpDAOProxy;

public class DAOFactory {

	public static IEmpDAO getIEmpDAOInstance() {

		return new IEmpDAOProxy();
	}
}
