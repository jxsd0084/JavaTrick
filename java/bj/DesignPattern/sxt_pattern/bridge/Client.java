package bj.DesignPattern.sxt_pattern.bridge;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 销售联想的笔记本电脑
		Computer2 c = new Laptop2( new Lenovo() );
		c.sale();

		// 销售神舟的台式机
		Computer2 c2 = new Desktop2( new Hasee() );
		c2.sale();

	}

}
