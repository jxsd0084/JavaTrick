package bj.mldn.javase01.no11;

class Person2 {

	private String name;
	private int    age;

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getInfo() {

		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}

public class ObjectArrayDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person2 p[] = { new Person2( "张三", 30 ), new Person2( "李四", 31 ), new Person2( "王五", 32 ) };
		for ( int x = 0; x < p.length; x++ ) {

			System.out.println( p[ x ].getInfo() );
		}

	}

}
