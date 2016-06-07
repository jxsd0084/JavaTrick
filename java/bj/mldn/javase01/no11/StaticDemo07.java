package bj.mldn.javase01.no11;

class Person3 {

	private        String name;
	private static int    count;

	public Person3() {

		count++;
		System.out.println( "产生了" + count + "个实例化对象。" );
	}

	public String getInfo() {

		return "姓名：" + this.name;
	}
}

public class StaticDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Person3();

		new Person3();

		new Person3();

		new Person3();

		new Person3();

	}

}
