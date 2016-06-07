package bj.mldn.javase02.ch13.no11;

import java.util.HashMap;
import java.util.Map;

class Person4 {

	private String name;
	private int    age;

	public Person4( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( !( obj instanceof Person4 ) ) {
			return false;
		}
		Person4 p = (Person4) obj;
		if ( this.name.equals( p.name ) && this.age == p.age ) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {

		return this.name.hashCode() * this.age;
	}
}

public class HashMapDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Map< Person4, String > map = null;
		map = new HashMap< Person4, String >();
		map.put( new Person4( "张三", 30 ), "zhangsan" );    // 增加内容
		System.out.println( map.get( new Person4( "张三", 30 ) ) );
	}
}
