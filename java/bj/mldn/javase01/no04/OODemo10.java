package bj.mldn.javase01.no04;

class Person3 {

	private String name;    // 表示人的姓名
	private int    age;     // 表示人的年龄

	public void tell() {    // 定义说话的方法

		System.out.println( "姓名：" + this.getName() + "，年龄：" + this.getAge() );
	}

	public void setName( String n ) {

		name = n;
	}

	public void setAge( int a ) {

		if ( a >= 0 && a <= 200 ) {
			age = a;
		}
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}
}

public class OODemo10 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person3 per = new Person3();  // 实例化对象

		per.setName( "张三" );          // 为name属性赋值
		per.setAge( - 30 );

		per.tell();

	}

}
