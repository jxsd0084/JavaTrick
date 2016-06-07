package bj.powernode.advance.Charpter19.web.servlet;

import bj.powernode.advance.Charpter19.domain.Emp;
import bj.powernode.advance.Charpter19.domain.EmpPage;
import bj.powernode.advance.Charpter19.domain.Users;
import bj.powernode.advance.Charpter19.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SearchEmpServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		this.doPost( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users       user    = (Users) session.getAttribute( "user" );


		if ( user != null ) {
			request.setCharacterEncoding( "utf-8" );

			int    currentPage    = 1;
			String strCurrentPage = request.getParameter( "currentPage" );
			if ( strCurrentPage != null ) {
				currentPage = Integer.parseInt( strCurrentPage );
			}
			Emp    emp    = new Emp();
			String reqSrc = request.getParameter( "reqScr" );
			// 请求是从search.jsp上面来的,要获取表单的参数,封装成Emp,作为查询条件
			if ( reqSrc != null && reqSrc.equals( "view" ) ) {
				String strEmpno = request.getParameter( "empno" );
				if ( strEmpno == null || "".equals( strEmpno ) ) {
					emp.setEmpno( - 1 );
				} else {
					int iEmpno = Integer.parseInt( strEmpno );
					emp.setEmpno( iEmpno );
				}

				String ename = request.getParameter( "ename" );
				if ( ename != null && ! "".equals( ename ) ) {
					emp.setEname( ename );
				}

				String job = request.getParameter( "job" );
				if ( job != null && ! "".equals( job ) ) {
					emp.setJob( job );
				}

				String strMgr = request.getParameter( "mgr" );
				if ( strMgr == null || "".equals( strMgr ) ) {
					emp.setMgr( - 1 );
				} else {
					int iMgr = Integer.parseInt( strMgr );
					emp.setMgr( iMgr );
				}
				String strHiredate = request.getParameter( "hiredate" );
				if ( strHiredate != null && ! "".equals( strHiredate ) ) {
					java.sql.Date hiredate = java.sql.Date.valueOf( strHiredate );
					emp.setHiredate( hiredate );
				}


				// 把查询条件保存起来
				session.setAttribute( "condition", emp );
			} else {
				// 这是从deleteEmp.do来的,要从session里面取出查询
				emp = (Emp) session.getAttribute( "condition" );
			}

			EmpService ee = new EmpService();

			EmpPage page = null;
			try {
				page = ee.page( emp, currentPage );
				request.setAttribute( "userPage", page );
				request.getRequestDispatcher( "listEmp.jsp" ).forward( request,
				                                                       response );
			} catch ( SQLException e ) {
				String error = e.getMessage();
				request.setAttribute( "msg", error );
				request.getRequestDispatcher( "searchEmp.jsp" ).forward( request,
				                                                         response );
			}
		} else {
			String errMsg = "对不起,您还没有登录,不能访问:" + request.getRequestURI();
			request.setAttribute( "errMsg", errMsg );
			request.getRequestDispatcher( "login.jsp" )
			       .forward( request, response );

		}
	}
}
