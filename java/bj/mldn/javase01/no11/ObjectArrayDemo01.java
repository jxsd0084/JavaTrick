package bj.mldn.javase01.no11;

class Person1 {

	private String name;
	private int    age;

	public Person1( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getInfo() {

		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}

public class ObjectArrayDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person1 p[] = new Person1[ 3 ];    // 3个长度的对象数组
		for ( int x = 0; x < p.length; x++ ) {

			System.out.print( p[ x ] + "、" );
		}

		System.out.println();

		p[ 0 ] = new Person1( "张三", 30 );
		p[ 1 ] = new Person1( "李四", 31 );
		p[ 2 ] = new Person1( "王五", 32 );

		for ( int x = 0; x < p.length; x++ ) {

			System.out.println( p[ x ].getInfo() );
		}

	}

}
