package bj.mldn.javase02.ch13.no05;

import java.util.Set;
import java.util.TreeSet;

class Person5 implements Comparable< Person5 > {

	private String name;
	private int    age;

	public Person5( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}

	public int compareTo( Person5 per ) {

		if ( this.age > per.age ) {
			return 1;
		} else if ( this.age < per.age ) {
			return -1;
		} else {
			return this.name.compareTo( per.name );    // 调用String中的compareTo()方法
		}
	}
}

public class TreeSetDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Set< Person5 > allSet = new TreeSet< Person5 >();
		allSet.add( new Person5( "张三", 30 ) );
		allSet.add( new Person5( "李四", 31 ) );
		allSet.add( new Person5( "王五", 32 ) );
		allSet.add( new Person5( "王五", 32 ) );
		allSet.add( new Person5( "王五", 32 ) );
		allSet.add( new Person5( "赵六", 33 ) );
		allSet.add( new Person5( "孙七", 33 ) );
		System.out.println( allSet );
	}
}
