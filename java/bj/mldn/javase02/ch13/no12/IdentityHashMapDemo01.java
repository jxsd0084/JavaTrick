package bj.mldn.javase02.ch13.no12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Person {

	private String name;
	private int    age;

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( !( obj instanceof Person ) ) {
			return false;
		}
		Person p = (Person) obj;
		if ( this.name.equals( p.name ) && this.age == p.age ) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {

		return this.name.hashCode() * this.age;
	}

	public String toString() {

		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}

public class IdentityHashMapDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Map< Person, String > map = null;    // 声明Map对象
		map = new HashMap< Person, String >();
		map.put( new Person( "张三", 30 ), "zhangsan_1" );    // 加入内容
		map.put( new Person( "张三", 30 ), "zhangsan_2" );    // 加入内容
		map.put( new Person( "李四", 31 ), "lisi" );          // 加入内容


		Set< Map.Entry< Person, String > > allSet = null;    // 准备使用Set接收全部内容
		allSet = map.entrySet();


		Iterator< Map.Entry< Person, String > > iter = null;
		iter = allSet.iterator();
		while ( iter.hasNext() ) {
			Map.Entry< Person, String > me = iter.next();
			System.out.println( me.getKey() + " --> " + me.getValue() );
		}
	}
}
