package bj.DesignPattern.sxt_pattern.adapter;

/**
 * 客户端类 (相当于例子中的笔记本，只有USB接口)
 *
 * @author Administrator
 */
public class Client {

	// Client依赖于Targe接口
	public void test1( Target t ) {

		t.handleReq();
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Client c = new Client();

		Adaptee a = new Adaptee();

		// Target t = new Adapter();

		Target t = new Adapter2( a );

		c.test1( t );

	}

}
