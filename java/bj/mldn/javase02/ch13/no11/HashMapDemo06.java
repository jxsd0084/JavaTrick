package bj.mldn.javase02.ch13.no11;

import java.util.HashMap;
import java.util.Map;

class Person2 {

	private String name;
	private int    age;

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class HashMapDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Map< Person2, String > map = null;
		map = new HashMap< Person2, String >();
		map.put( new Person2( "张三", 30 ), "zhangsan" );    // 增加内容
		System.out.println( map.get( new Person2( "张三", 30 ) ) );
	}
}
