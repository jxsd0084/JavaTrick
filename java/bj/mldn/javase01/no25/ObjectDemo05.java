package bj.mldn.javase01.no25;

class Person4 {

	public String toString() {    // 覆写了toString()方法
		return "Hello";
	}
}

public class ObjectDemo05 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String arg[] ) {

		System.out.println( new Person4() );
	}

}
