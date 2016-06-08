package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section2;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         业务场景类
 */
public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		IDriver zhangSan = new Driver();

		// ICar benz = new Benz();
		// ICar bmw = new BMW();

		// 张三开奔驰车
		// zhangSan.drive(bmw);

		// 对象方法
		zhangSan.drive( new Benz() );

	}

}
