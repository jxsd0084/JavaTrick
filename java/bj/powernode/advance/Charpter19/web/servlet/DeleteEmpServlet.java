package bj.powernode.advance.Charpter19.web.servlet;

import bj.powernode.advance.Charpter19.dao.EmpDao;
import bj.powernode.advance.Charpter19.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteEmpServlet extends HttpServlet {

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

			String strEmpno = request.getParameter( "empno" );

			EmpDao ed = new EmpDao();

			if ( ed.deleteByEmpno( Integer.parseInt( strEmpno ) ) ) {
				// request.getRequestDispatcher("searchEmp.do").forward(request,
				// response);
				response.sendRedirect( "searchEmp.do" );
			}
		} else {
			String errMsg = "对不起,您还没有登录,不能访问:" + request.getRequestURI();
			request.setAttribute( "errMsg", errMsg );
			request.getRequestDispatcher( "login.jsp" )
			       .forward( request, response );

		}
	}
}
