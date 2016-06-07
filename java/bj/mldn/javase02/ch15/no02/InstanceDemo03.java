package bj.mldn.javase02.ch15.no02;

import java.lang.reflect.Constructor;

class Person3 {

	private String name;    // name属性
	private int    age;        // age属性

	public Person3( String name, int age ) {

		this.setName( name );
		this.setAge( age );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}

	public String toString() {    // 覆写toString()方法
		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}

public class InstanceDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Class< ? > c = null;        // 声明Class对象
		try {
			c = Class.forName( "org.lxh.demo15.instancedemo.Person" );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		Person3          per    = null;    // 声明Person对象
		Constructor< ? > cons[] = null;
		cons = c.getConstructors();
		try {
			per = (Person3) cons[ 0 ].newInstance( "李兴华", 30 );    // 实例化对象
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		System.out.println( per );    // 内容输出，调用toString()
	}
}
