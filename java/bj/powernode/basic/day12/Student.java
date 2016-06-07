package bj.powernode.basic.day12;

import java.util.*;

/*

	测试SortedSet.(从小到大排序.)
	Student类实现了 Comparable接口 ,代表学生对象是可比较的
	
	java.util.SortedSet;<<interface>>
		java.util.TreeSet;  (impl_class)
	
	
	该例子：比较大小的规则 --> 根据学号字典顺序排列.

*/
public class Student implements Comparable {

	private String name;
	private String stuNo;


	public Student() {

		super();
	}

	public Student( String stuNo, String name ) {

		super();
		this.stuNo = stuNo;
		this.name = name;
	}


	public String getName() {

		return name;
	}

	public String getStuNo() {

		return stuNo;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setStuNo( String stuNo ) {

		this.stuNo = stuNo;
	}


	// s1.compareTo(s2);
	public int compareTo( Object o ) {

		Student s = (Student) o;
		return this.getStuNo().compareTo( s.getStuNo() );
	}

	public String toString() {

		return "[stuNo=" + stuNo + ",name=" + name + "]";
	}


	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( this == obj ) {

			return true;
		}

		if ( obj instanceof Student ) {

			Student s = (Student) obj;

			if ( s.getStuNo().equals( this.getStuNo() ) && s.getName().equals( this.getName() ) ) {

				return true;
			}
		}

		return false;
	}

	public int hashCode() {

		return stuNo.hashCode() + name.hashCode();
	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {




		// 1.创建SortedSet集合
		SortedSet students = new TreeSet();





		// 2.准备学生对象
		Student s1 = new Student( "001", "jack" );
		Student s2 = new Student( "002", "sun" );

		System.out.println( s1.toString() );
		System.out.println( s2 );






		// 3.添加元素
		students.add( s1 );
		students.add( s2 );






		// 4.获取集合的长度.
		System.out.println( students.size() );  // a.compareTo(b).  0 (a等于b)  负整数(a<b) 正整数(a>b)
		// 如果a等于b，则放弃添加b元素.


		System.out.println( "==================================" );






		// 5.遍历集合
		Iterator it = students.iterator();
		while ( it.hasNext() ) {

			System.out.println( it.next() );
		}

	}

}
