package bj.mldn.javase02.ch13.no05;

import java.util.Set;
import java.util.TreeSet;

class Person3 {

	private String name;
	private int    age;

	public Person3( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String gtoString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class TreeSetDemo02 {

	public static void main( String args[] ) {

		Set< Person3 > allSet = new TreeSet< Person3 >();
		allSet.add( new Person3( "张三", 30 ) );
		allSet.add( new Person3( "李四", 31 ) );
		allSet.add( new Person3( "王五", 32 ) );
		allSet.add( new Person3( "王五", 32 ) );
		allSet.add( new Person3( "王五", 32 ) );
		allSet.add( new Person3( "赵六", 33 ) );
		allSet.add( new Person3( "孙七", 33 ) );
		System.out.println( allSet );
	}
}
