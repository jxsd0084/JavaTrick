package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务场景类
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Driver zhangSan = new Driver();
		Benz   benz     = new Benz();

		// 张三开奔驰车
		zhangSan.drive( benz );
	}

}
