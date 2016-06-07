package bj.mldn.javase02.ch13.no11;

import java.util.HashMap;
import java.util.Map;

class Person3 {

	private String name;
	private int    age;

	public Person3( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class HashMapDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Map< Person3, String > map = null;
		map = new HashMap< Person3, String >();
		Person3 per = new Person3( "张三", 30 );
		map.put( per, "zhangsan" );    // 增加内容
		System.out.println( map.get( per ) );
	}
}
