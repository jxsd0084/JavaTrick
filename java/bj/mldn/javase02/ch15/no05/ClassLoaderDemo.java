package bj.mldn.javase02.ch15.no05;

class Person {

}

public class ClassLoaderDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Person stu = new Person();
		System.out.println( "类加载器：" + stu.getClass().getClassLoader().getClass().getName() );
	}
}
