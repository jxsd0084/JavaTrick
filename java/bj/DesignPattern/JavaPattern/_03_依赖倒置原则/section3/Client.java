package bj.DesignPattern.JavaPattern._03_依赖倒置原则.section3;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Client {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 根据接口虚拟一个对象
		final ICar car    = new Audio();
		IDriver    driver = new Driver();

		driver.drive( car );

	}
	
}
