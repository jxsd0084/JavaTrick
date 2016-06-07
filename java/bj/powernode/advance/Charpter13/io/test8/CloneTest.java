package bj.powernode.advance.Charpter13.io.test8;

public class CloneTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 浅克隆只是增加了一个对象的引用 相当于增加一个代理 两个引用指向同一个对象
		// 而深克隆 是复制整个对象 所以内存中是两个对象
		Teacher t   = new Teacher( "老吴" );
		Student stu = new Student( "张一", t );

		try {

			Student s1 = (Student) stu.clone();
			System.out.println( stu.hashCode() + "        " + s1.hashCode() );
			System.out.println( stu == s1 );

			System.out.println( s1.getTeacher().hashCode() + "  " +
			                    stu.getTeacher().hashCode() );

			// 重写 clone 方法的应用程序也可能抛出此异常，指示不能或不应复制一个对象
			// 当调用 Object 类中的 clone 方法复制对象，但该对象的类无法实现 Cloneable 接口时，抛出该异常
		} catch ( CloneNotSupportedException e ) {
			e.printStackTrace();
		}
	}
}
