package bj.mldn.javase02.ch05.no09;

class Person8 {             // 定义Person类

	private String name;    // 姓名
	private int    age;     // 年龄

	public Person8( String name, int age ) {

		this.setName( name );
		this.setAge( age );
	}

	public boolean compare( Person8 per ) {
		// 调用此方法时里面存在两个对象：当前对象、传入的对象
		Person8 p1 = this;    // 当前的对象，就表示per1
		Person8 p2 = per;     // 传递进来的对象，就表示per2
		if ( p1 == p2 ) {     // 判断是不是同一个对象，用地址比较
			return true;
		}
		// 之后分别判断每一个属性是否相等
		if ( p1.name.equals( p2.name ) && p1.age == p2.age ) {
			return true;      // 两个对象相等
		} else {
			return false;     // 两个对象不相等
		}
	}

	public void setName( String name ) {    // 设置姓名
		this.name = name;
	}

	public void setAge( int age ) {        // 设置年龄
		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

public class ThisDemo08 {

	public static void main( String args[] ) {

		Person8 per1 = new Person8( "张三", 30 );    // 声明两个对象，内容完全相等
		Person8 per2 = new Person8( "张三", 30 );    // 声明两个对象，内容完全相等

		// 直接在主方法中依次取得各个属性进行比较
		if ( per1.compare( per2 ) ) {
			System.out.println( "两个对象相等！" );
		} else {
			System.out.println( "两个对象不相等！" );
		}
	}

}
