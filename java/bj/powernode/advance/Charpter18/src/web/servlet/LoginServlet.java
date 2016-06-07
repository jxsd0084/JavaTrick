package bj.powernode.advance.Charpter18.src.web.servlet;

import bj.powernode.advance.Charpter18.src.dao.UsersDao;
import bj.powernode.advance.Charpter18.src.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		// 1.取得表单的数据,封装成一个对象
		// 2.调用dao的validataUsers()方法
		// 3.如果校验通过,跳转到index.jsp,显示用户的功能
		// 4.如果校验失败,添加错误信息后,跳转到login.jsp
		request.setCharacterEncoding( "utf-8" );
		String name     = request.getParameter( "name" );
		String password = request.getParameter( "password" );

		Users user = new Users();
		user.setName( name );
		user.setPassword( password );

		UsersDao ud = new UsersDao();
		if ( ud.validataUsers( user ) ) {
			HttpSession session = request.getSession();
			session.setAttribute( "user", user );
			response.sendRedirect( "index.jsp" );
		} else {
			String errMsg = "错误的用户名或密码!";
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
