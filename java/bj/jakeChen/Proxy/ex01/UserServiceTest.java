package bj.jakeChen.Proxy.ex01;

/**
 * Created by chenlong on 2016/5/23.
 */
public class UserServiceTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		UserServiceProxy proxy   = new UserServiceProxy();
		UserServiceBean  bean    = new UserServiceBean( "wuq" );
		UserService      service = (UserService) proxy.createProxyInstance( bean );
		service.say();
	}

}

/*

URL:    http://www.360doc.com/content/13/0116/13/11261516_260506834.shtml

*/