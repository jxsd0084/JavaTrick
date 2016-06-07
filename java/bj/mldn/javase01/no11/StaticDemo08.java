package bj.mldn.javase01.no11;

class Person4 {

	private        String name;
	private static int    count;

	public Person4() {

		count++;
		this.name = "NONAME - " + count;    // 自动命名
	}

	public Person4( String name ) {

		this.name = name;
	}

	public String getInfo() {

		return "姓名：" + this.name;
	}
}

public class StaticDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( new Person4().getInfo() );

		System.out.println( new Person4( "A" ).getInfo() );

		System.out.println( new Person4( "B" ).getInfo() );

		System.out.println( new Person4().getInfo() );

	}

}
