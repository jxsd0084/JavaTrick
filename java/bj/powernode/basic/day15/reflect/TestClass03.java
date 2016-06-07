package bj.powernode.basic.day15.reflect;

/*

	获取类的基因信息的第三种方式:
		Class c = 类名.class;

*/

public class TestClass03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Class catClass    = Cat.class;  // 这种方式没有类加载
		Class dogClass    = Dog.class;
		Class stringClass = String.class;

		System.out.println( catClass );
		System.out.println( dogClass );
		System.out.println( stringClass );

	}

}
