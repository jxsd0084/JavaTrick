package bj.powernode.basic.day11.EqualsHashCode;
/*

	equals方法要和hashCode方法一起重写.
	
	现实中：如果两个对象是equals的.那么这两个对象的 哈希码 应该一致.
	如果两个对象不是equals的.那么这两个对象的 哈希码 不应该一致.

*/

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Student s1 = new Student( "aaa" );
		Student s2 = new Student( "aaa" );
		Student s3 = new Student( "刘德华" );



		System.out.println( s1.equals( s2 ) );                  // true
		System.out.println( s1.hashCode() == s2.hashCode() );   // true




		System.out.println( s1.equals( s3 ) );                  // false
		System.out.println( s1.hashCode() == s3.hashCode() );   // false




	}

}
