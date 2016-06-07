package bj.DesignPattern.sxt_pattern.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Star        realStar = new RealStar();
		StarHandler handler  = new StarHandler( realStar );

		Star proxy = (Star) Proxy.newProxyInstance( ClassLoader.getSystemClassLoader(),
				new Class[]{ Star.class }, handler );

		proxy.sing();

	}

}