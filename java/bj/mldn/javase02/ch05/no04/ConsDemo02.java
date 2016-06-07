package bj.mldn.javase02.ch05.no04;

class Person2 {

	private String name;
	private int    age;

	public Person2( String n, int a ) {        // 声明构造方法，为类中的属性初始化
		this.setName( n );
		this.setAge( a );
	}

	public void setName( String n ) {

		name = n;
	}

	public void setAge( int a ) {

		if ( a > 0 && a < 150 ) {
			age = a;
		}
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}

	public void tell() {

		System.out.println( "姓名：" + this.getName() + "；年龄：" + this.getAge() );
	}
}

public class ConsDemo02 {

	public static void main( String args[] ) {

		System.out.println( "声明对象：Person per = null ;" );
		Person2 per = null;                 // 声明对象时并不去调用构造方法
		System.out.println( "实例化对象：per = new Person() ;" );
		per = new Person2( "张三", 30 );    // 实例化对象
		per.tell();
	}

}
