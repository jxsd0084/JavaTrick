package bj.mldn.javase02.ch06.no11;

class Person2 {

	private String name;    // 定义name属性
	private int    age;        // 定义age属性

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {        // 地址相等
			return true;    // 肯定是同一个对象
		}
		if ( !( obj instanceof Person2 ) ) {    // 不是Person对象
			return false;
		}
		Person2 per = (Person2) obj;    // 向下转型
		if ( per.name.equals( this.name ) && per.age == this.age ) {
			return true;    // 依次比较内容
		} else {
			return false;
		}
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class ObjectDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Person2 per1 = new Person2( "李兴华", 30 );     // 实例化Person
		Person2 per2 = new Person2( "李兴华", 30 );     // 实例化Person
		System.out.println( per1.equals( per2 ) ? "是同一个人！" : "不是同一个人！" );
		System.out.println( per1.equals( "hello" ) ? "是同一个人！" : "不是同一个人！" );

	}
}
