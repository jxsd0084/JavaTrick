package bj.crazy.ch18.u05.DynaProxy;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 创建一个原始的GunDog对象，作为target

		Dog target = new GunDog();





		// 以指定的target来创建动态代理

		Dog dog = (Dog) MyProxyFactory.getProxy( target );

		dog.info();

		dog.run();

	}

}
