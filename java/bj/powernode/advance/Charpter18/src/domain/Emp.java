package bj.powernode.advance.Charpter18.src.domain;

import java.sql.Date;

// domain包下面主要存放的是抽象出来的表的对象
// 数据库表的每一个字段对应对象的一个属性
public class Emp {

	// 属性
	private int empno, deptno, mgr;
	private String ename, job;
	private double sal, comm;
	private Date hiredate;

	// set/get方法
	public int getEmpno() {

		return empno;
	}

	public void setEmpno( int empno ) {

		this.empno = empno;
	}

	public int getDeptno() {

		return deptno;
	}

	public void setDeptno( int deptno ) {

		this.deptno = deptno;
	}

	public int getMgr() {

		return mgr;
	}

	public void setMgr( int mgr ) {

		this.mgr = mgr;
	}

	public String getEname() {

		return ename;
	}

	public void setEname( String ename ) {

		this.ename = ename;
	}

	public String getJob() {

		return job;
	}

	public void setJob( String job ) {

		this.job = job;
	}

	public double getSal() {

		return sal;
	}

	public void setSal( double sal ) {

		this.sal = sal;
	}

	public double getComm() {

		return comm;
	}

	public void setComm( double comm ) {

		this.comm = comm;
	}

	public Date getHiredate() {

		return hiredate;
	}

	public void setHiredate( Date hiredate ) {

		this.hiredate = hiredate;
	}

}
