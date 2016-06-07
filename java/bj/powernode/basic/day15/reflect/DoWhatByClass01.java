package bj.powernode.basic.day15.reflect;

/*

	通过类的基因信息动态创建对象.

*/
public class DoWhatByClass01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 获取类的基因信息.
		Class catClass = Class.forName( "Cat" );  // 类加载

		// 创建Cat对象
		Object obj = catClass.newInstance();      // 调用了无参数构造方法.

		// 输出c
		if ( obj instanceof Cat ) {

			Cat c = (Cat) obj;

			System.out.println( c );
		}

		// 动态创建狗对象
		Class dogClass = Class.forName( "Dog" );

		System.out.println( dogClass.newInstance() );

	}

}
