package bj.geym.ch10.findorder;

/**
 * -Xbootclasspath/a:D:/tmp/clz
 * -XBootClasspath 指定 说明加载先从启动classloader开始
 *
 * @author Administrator
 */
public class FindClassOrder {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		HelloLoader loader = new HelloLoader();
		loader.print();
	}
}
