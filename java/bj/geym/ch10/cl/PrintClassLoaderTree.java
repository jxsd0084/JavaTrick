package bj.geym.ch10.cl;

public class PrintClassLoaderTree {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		ClassLoader cl = PrintClassLoaderTree.class.getClassLoader();
		while ( cl != null ) {
			System.out.println( cl );
			cl = cl.getParent();
		}
		System.out.println( "String classloader:" + String.class.getClassLoader() );
	}
}
