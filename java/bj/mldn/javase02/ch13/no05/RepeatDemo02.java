package bj.mldn.javase02.ch13.no05;

import java.util.HashSet;
import java.util.Set;

class Person2 {

	private String name;
	private int    age;

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public boolean equals( Object obj ) {    // 覆写equals，完成对象比较
		if ( this == obj ) {
			return true;
		}
		if ( ! ( obj instanceof Person2 ) ) {
			return false;
		}
		Person2 p = (Person2) obj;    // 向下转型
		if ( this.name.equals( p.name ) && this.age == p.age ) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {

		return this.name.hashCode() * this.age; // 定义一个公式
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class RepeatDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Set< Person2 > allSet = new HashSet< Person2 >();
		allSet.add( new Person2( "张三", 30 ) );
		allSet.add( new Person2( "李四", 31 ) );
		allSet.add( new Person2( "王五", 32 ) );
		allSet.add( new Person2( "王五", 32 ) );
		allSet.add( new Person2( "王五", 32 ) );
		allSet.add( new Person2( "赵六", 33 ) );
		allSet.add( new Person2( "孙七", 33 ) );
		System.out.println( allSet );
	}
}
