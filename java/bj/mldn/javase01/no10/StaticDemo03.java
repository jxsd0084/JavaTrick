package bj.mldn.javase01.no10;

class Person3 {

	private String name;
	private int    age;
	private static String city = "A城";

	public static void setCity( String c ) {

		city = c;
	}

	public Person3( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getInfo() {

		return "姓名：" + this.name + "，年龄：" + this.age + "，城市：" + city;
	}
}

public class StaticDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person3 per1 = new Person3( "张三", 30 );
		Person3 per2 = new Person3( "李四", 31 );
		Person3 per3 = new Person3( "王五", 30 );


		System.out.println( "============= 信息修改之前 ================" );
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );


		System.out.println( "============= 信息修改之后 ================" );
		Person3.setCity( "B城" );
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );

	}

}
