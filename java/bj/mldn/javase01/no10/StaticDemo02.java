package bj.mldn.javase01.no10;

class Person2 {

	private String name;
	private int    age;
	static String city = "A城";

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getInfo() {

		return "姓名：" + this.name + "，年龄：" + this.age + "，城市：" + city;
	}
}

public class StaticDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person2 per1 = new Person2( "张三", 30 );
		Person2 per2 = new Person2( "李四", 31 );
		Person2 per3 = new Person2( "王五", 30 );



		System.out.println( "============= 信息修改之前 ================" );
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );



		System.out.println( "============= 信息修改之后 ================" );
		Person2.city = "B城";
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );

	}

}
