package bj.powernode.basic.day15.reflect;

/*

	获取类的基因信息的第二种方式:
		Class c = 对象名.getClass();

*/

public class TestClass02 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		// 1.创建Cat对象
		Cat   c        = new Cat();                     // 类加载过程.
		Class catClass = c.getClass();
		System.out.println( catClass );


		Cat   c1        = new Cat();
		Class catClass2 = c1.getClass();
		System.out.println( catClass2 );




		// 类的基因信息在内存中永远只有一份.
		System.out.println( catClass == catClass2 );    // true


		Dog   d        = new Dog();
		Class dogClass = d.getClass();
		System.out.println( dogClass );

	}

}
