package bj.DesignPattern.ym_pattern.facade.example2;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		// 不用Facade，需要自己跟多个模块交互
//		AModuleApi a = new AModuleImpl();
//		a.testA();
//		BModuleApi b = new BModuleImpl();
//		b.testB();
//		CModuleApi c = new CModuleImpl();
//		c.testC();
//		
//		System.out.println("使用Facade----------------------〉");

		// 使用了Facade
		new Facade().test();

	}

}
