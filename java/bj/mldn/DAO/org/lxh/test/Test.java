package bj.mldn.DAO.org.lxh.test;

import bj.mldn.DAO.org.lxh.oracle.dao.factory.DAOFactory;
import bj.mldn.DAO.org.lxh.oracle.vo.Emp;

import java.util.Date;

public class Test {

	public static void main(String[] args) {

		Emp emp = new Emp();
		emp.setEmpno(1111);
		emp.setEname("张三");
		emp.setJob("经理");
		emp.setHiredate(new Date());
		emp.setSal(899.9f);
		emp.setComm(89.9f);
		emp.setPhoto("nophoto.jpg");
		try {
			DAOFactory.getIEmpDAOInstance().doUpdate(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
