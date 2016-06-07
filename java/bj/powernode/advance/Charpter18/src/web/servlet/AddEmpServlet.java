package bj.powernode.advance.Charpter18.src.web.servlet;

import bj.powernode.advance.Charpter18.src.dao.EmpDao;
import bj.powernode.advance.Charpter18.src.domain.Emp;
import bj.powernode.advance.Charpter18.src.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//这是一个Servlet,位于服务器端,专门用来处理修改emp表的请求,继承自HttpServlet
public class AddEmpServlet extends HttpServlet {

	// doGet方法
	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users       user    = (Users) session.getAttribute( "user" );

		if ( user != null ) {

			// 将字符编号转换为"utf-8"
			request.setCharacterEncoding( "utf-8" );

			// 获得String类型的数据
			String strEmpno = request.getParameter( "empno" );
			// 将String类型的变量通过parseInt()方法转换为int类型
			int    iEmpno = Integer.parseInt( strEmpno );
			String ename  = request.getParameter( "ename" );
			String job    = request.getParameter( "job" );

			String strMgr = request.getParameter( "mgr" );
			// 将String类型转换为int类型
			int           iMgr        = Integer.parseInt( strMgr );
			String        strHiredate = request.getParameter( "hiredate" );
			java.sql.Date hriedate    = java.sql.Date.valueOf( strHiredate );
			String        strSal      = request.getParameter( "sal" );
			// 将String类型转换为double类型
			double dSal = Double.parseDouble( strSal );

			// 将String类型转换为double类型
			String strComm = request.getParameter( "comm" );
			double dComm   = Double.parseDouble( strComm );

			// 将String类型转换为int类型
			String strDeptno = request.getParameter( "deptno" );
			int    iDeptno   = Integer.parseInt( strDeptno );

			// 创建emp表对象
			Emp emp = new Emp();

			// 调用emp中的set方法对表中的参数进行设置,总共8个关键字段
			emp.setEmpno( iEmpno );
			emp.setEname( ename );
			emp.setJob( job );
			emp.setMgr( iMgr );
			emp.setHiredate( hriedate );
			emp.setSal( dSal );
			emp.setComm( dComm );
			emp.setDeptno( iDeptno );

			// 创建一个EmpDao的对象
			EmpDao ed = new EmpDao();

			// 准备一个String类型的变量mgs,用来输出信息
			String msg = null;
			try {

				// if条件判断,如果插入成功
				if ( ed.insertEmp( emp ) ) {

					// 将"员工插入成功!"信息赋给msg变量
					msg = "员工插入成功!";
				}
			} catch ( SQLException e ) {

				// 如果发生了异常,将异常信息赋给err变量
				String error = e.getMessage();

				// error变量再赋值给msg
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

	// doPost方法,方法中调用doGet方法
	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		this.doGet( request, response );
	}

}
