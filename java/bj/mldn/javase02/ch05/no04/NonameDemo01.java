package bj.mldn.javase02.ch05.no04;

class Person4 {

	private String name;
	private int    age;

	public Person4( String n, int a ) {        // 声明构造方法，为类中的属性初始化
//		this.setName( n );
//		this.setAge( a );
		this.name = n;
		this.age  = a;
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

public class NonameDemo01 {

	public static void main( String args[] ) {

		new Person4( "张三", 30 ).tell();
	}
}
