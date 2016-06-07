package bj.powernode.advance.Charpter19.web.servlet;

import bj.powernode.advance.Charpter19.dao.EmpDao;
import bj.powernode.advance.Charpter19.domain.Emp;
import bj.powernode.advance.Charpter19.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AddEmpServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users       user    = (Users) session.getAttribute( "user" );

		if ( user != null ) {
			request.setCharacterEncoding( "utf-8" );
			String strEmpno = request.getParameter( "empno" );
			int    iEmpno   = Integer.parseInt( strEmpno );
			String ename    = request.getParameter( "ename" );
			String job      = request.getParameter( "job" );

			String        strMgr      = request.getParameter( "mgr" );
			int           iMgr        = Integer.parseInt( strMgr );
			String        strHiredate = request.getParameter( "hiredate" );
			java.sql.Date hriedate    = java.sql.Date.valueOf( strHiredate );
			String        strSal      = request.getParameter( "sal" );
			double        dSal        = Double.parseDouble( strSal );

			String strComm = request.getParameter( "comm" );
			double dComm   = Double.parseDouble( strComm );

			String strDeptno = request.getParameter( "deptno" );
			int    iDeptno   = Integer.parseInt( strDeptno );

			Emp emp = new Emp();
			emp.setEmpno( iEmpno );
			emp.setEname( ename );
			emp.setJob( job );
			emp.setMgr( iMgr );
			emp.setHiredate( hriedate );
			emp.setSal( dSal );
			emp.setComm( dComm );
			emp.setDeptno( iDeptno );

			EmpDao ed = new EmpDao();

			// 如果插入数据成功
			String msg = null;
			try {
				if ( ed.insertEmp( emp ) ) {
					msg = "员工插入成功!";
				}
			} catch ( SQLException e ) {
				String error = e.getMessage();
				msg = error;
			}
			request.setAttribute( "msg", msg );
			request.getRequestDispatcher( "addEmp.jsp" ).forward( request,
			                                                      response );

		} else {
			String errMsg = "对不起,您还没有登录,不能访问:" + request.getRequestURI();
			request.setAttribute( "errMsg", errMsg );
			request.getRequestDispatcher( "login.jsp" )
			       .forward( request, response );

		}

	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		this.doGet( request, response );
	}

}
