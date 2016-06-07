
package bj.powernode.basic.day06.TestInterface;


/*

	java语言中的接口
	
	
	什么是接口:接口是特殊的抽象类.
	
	接口中只能有：抽象方法+常量
	
	1.在java语言中如何定义一个接口
		public interface CustomerService{}
	
	2.一个类继承了该接口,必须重写接口中所有的抽象方法.
	  改进：一个类实现了该接口，必须实现接口中所有的方法. (语法要求)
	  接口什么作用： 规范实现类的行为.
	  
	 
	3.一个接口可以继承多个接口.(解决了java语言的单继承问题.)

*/
interface ProductService {

	public void changePrice();
}

interface SystemService {

	public void logout();

}


public interface UserService extends SystemService, ProductService {

	//  java语言中“常量”的命名规则：全部大写

	public static final int I = 10;         // 常量.

	public static final String SUCCESS = "success";

	public String FAIL = "fail";            //  会在前面默认添加 static final

	String OK = "ok";

	//  private String OK = "ok";           //  接口中常量不能私有化

	//  protected String ISOK = "isok";     //  接口中常量不能 protected


	//  接口语法要求：所有的方法都是抽象方法.
	public abstract boolean login( String name, String password );


	//  该方法不是抽象方法.
	//  public void m(){}

	//  编译能通过吗？ 编译的时候编译器自动给该方法添加abstract关键字.
	public void test();

}


//  一个类如何去实现一个接口呢?
class UserServiceImpl implements UserService {

	public boolean login( String name, String password ) {

		System.out.println( "name=" + name );
		System.out.println( "password=" + password );
		return false;
	}

	public void test() {

	}


	public void logout() {

	}


	public void changePrice() {

	}


	//  程序入口.
	public static void main( String[] args ) {

		UserService us = new UserServiceImpl();  // 多态

		us.login( "robin", "123" );

	}

}
