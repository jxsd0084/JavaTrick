package bj.powernode.advance.Charpter04.test6;

public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p1 = new Person( "张一", 21 );
		Person p2 = new Person( "张一", 21 );

		System.out.println( p1.hashCode() + " " + p2.hashCode() );
		System.out.println( p1.equals( p2 ) );

		System.out.println( p1.equals( p2 ) );


		// == 对于引用类型来说,比较的是两个引用的地址是否相同
		System.out.println( p1 == p2 );


	}

}
