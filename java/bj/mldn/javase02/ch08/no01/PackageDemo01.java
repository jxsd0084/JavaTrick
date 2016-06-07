// 定义一个包
package bj.mldn.javase02.ch08.no01;

class Demo2 {

	public String getInfo() {

		return "Hello World!!!";
	}
}

public class PackageDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( new Demo2().getInfo() );
	}
}
