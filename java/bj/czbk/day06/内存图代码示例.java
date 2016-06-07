package bj.czbk.day06;

class Person3 {

	private String name;
	private int    age;
	private static String country = "cn";

	Person3() {

	}

	Person3( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	{
		System.out.println( name + "src/test" + age );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void speak() {

		System.out.println( this.name + "..." + this.age );
	}

	public static void showCountry() {

		System.out.println( "country=" + country );
	}
}

class PersonDemo2 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Person3 p = new Person3();
	}
}
