package bj.powernode.advance.Charpter19.web.servlet;

import bj.powernode.advance.Charpter19.dao.UsersDao;
import bj.powernode.advance.Charpter19.domain.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet处理分支:
 * <p>
 * 1.验证通过-->"index.jsp"
 * <p>
 * 2.验证不通过-->"login.jsp"
 */

public class LoginServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		// 1.取得表单的数据,封装成一个对象
		// 设置字符编码格式
		request.setCharacterEncoding( "utf-8" );

		// 用请求.getParameter()方法获取登录界面上面的信息
		// 登录界面上面有两个关键数据,一个用户名"name"表示,另外一个是密码"password"
		String name     = request.getParameter( "name" );
		String password = request.getParameter( "password" );

		// 将从界面上面取得的信息封装成为一个Users对象,包含两个属性:1.name;2.password
		Users user = new Users();
		// 把获取到的name和password传递到user里面去
		user.setName( name );
		user.setPassword( password );

		// 下面创建UsersDao类的对象,调用UsersDao的validataUsers()方法
		// 2.调用dao的validataUsers()方法
		UsersDao ud = new UsersDao();

		// 3.如果传递进来的user校验通过,则跳转到index.jsp,显示用户的功能
		if ( ud.validataUsers( user ) ) {

			// 创建一个HttpSession类型的对象,还要把HttpSession包给导入
			HttpSession session = request.getSession();

			// 调用HttpSession的setAttribute方法,将user传递进去
			// 在通过session去调用setAttribute方法将user传入
			session.setAttribute( "user", user );

			// 跳转到"index.jsp"页面中去,注意:这个跳转页面的方法是无法传递数据的
			// 用response去调用sendRedirect方法跳转到"index.jsp"页面上去
			response.sendRedirect( "index.jsp" );

			// 分支语句
		} else {

			// 4.如果校验失败,添加错误信息后,跳转到login.jsp
			// 准备了一个String类型的错误输出信息,输出"错误的用户名或密码!"
			String errMsg = "错误的用户名或密码!";

			// 用request调用setAttribute方法将"错误信息"放进去传递出去
			request.setAttribute( "errMsg", errMsg );

			// 用request调用getRequestDispatch方法将"请求"和"响应"传递到"login.jsp"页面上去
			request.getRequestDispatcher( "login.jsp" )
			       .forward( request, response );
		}
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		this.doGet( request, response );
	}

}
