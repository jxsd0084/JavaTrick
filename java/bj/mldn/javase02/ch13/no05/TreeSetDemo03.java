package bj.mldn.javase02.ch13.no05;

import java.util.Set;
import java.util.TreeSet;

class Person4 implements Comparable< Person4 > {

	private String name;
	private int    age;

	public Person4( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}

	public int compareTo( Person4 per ) {

		if ( this.age > per.age ) {
			return 1;
		} else if ( this.age < per.age ) {
			return - 1;
		} else {
			return 0;
		}
	}
}

public class TreeSetDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Set< Person4 > allSet = new TreeSet< Person4 >();
		allSet.add( new Person4( "张三", 30 ) );
		allSet.add( new Person4( "李四", 31 ) );
		allSet.add( new Person4( "王五", 32 ) );
		allSet.add( new Person4( "王五", 32 ) );
		allSet.add( new Person4( "王五", 32 ) );
		allSet.add( new Person4( "赵六", 33 ) );
		allSet.add( new Person4( "孙七", 33 ) );
		System.out.println( allSet );
	}
}
