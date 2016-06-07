package bj.DesignPattern.JavaPattern._28_享元模式.section1;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String[] args) {

		// 从工厂中获得一个对象
		SignInfo signInfo = SignInfoFactory.getSignInfo();

		// 进行其他业务处理

	}
	
}
