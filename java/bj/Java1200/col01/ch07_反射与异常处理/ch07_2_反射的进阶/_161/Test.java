package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._161;

import java.lang.reflect.Proxy;

/**
 * 反射与动态代理
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Seller seller = new HouseSeller();
		System.out.println( "不使用代理方式：" );
		seller.sell();// 普通方式调用sell()方法
		System.out.println( "使用代理方式：" );
		ClassLoader loader = Seller.class.getClassLoader();// 获得Seller类的类加载器
		seller = (Seller) Proxy.newProxyInstance( loader, new Class[]{ Seller.class }, new Agency() );
		seller.sell();// 代理方式调用sell()方法

	}

}
