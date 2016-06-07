package bj.mldn.javase01.no10;

class Person4 {

	private String name;
	private int    age;
	private static String city = "A城";

	public Person4( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public static void setCity( String c ) {

		city = c;
//		this.name = "张三";
//		this.getInfo();
	}


	public String getInfo() {

		return "姓名：" + this.name + "，年龄：" + this.age + "，城市：" + city;
	}
}

public class StaticDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person4 per1 = new Person4( "张三", 30 );
		Person4 per2 = new Person4( "李四", 31 );
		Person4 per3 = new Person4( "王五", 30 );


		System.out.println( "============= 信息修改之前 ================" );
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );


		System.out.println( "============= 信息修改之后 ================" );
		Person4.setCity( "B城" );
		System.out.println( per1.getInfo() );
		System.out.println( per2.getInfo() );
		System.out.println( per3.getInfo() );

	}

}
