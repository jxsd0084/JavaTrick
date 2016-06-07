package bj.powernode.basic.day16.reflect;

/*

	获取类的包信息

*/
public class GetPackageByClass {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.获取User的基因信息.
		Class c = Class.forName( "com.dlpowernode.reflect.User" );

		// 2.获取关于package部分的元素.
		Package p = c.getPackage();  // package的基因片段

		// 3.将package显示出来
		System.out.println( p.toString() + ";" );

		// 4.输出此包的名称
		System.out.println( p.getName() );

	}


}
