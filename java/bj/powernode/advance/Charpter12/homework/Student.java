package bj.powernode.advance.Charpter12.homework;

import java.util.*;

/*

	定义一个Student类，

    代表学生，在Student类中包含一个属性是一个HashSet
    的对象，用来存储该学生所选的所有课程，并提供相
    应的addCourse(Course c)方法和removeCourse(String name)
    方法，表示添加一门选课和删除一门选课

    （删除选课时通过传课程名参数来确定）

 */
public class Student {

	// 用来储存课程的集合
	private Set< Course > hashSet = new HashSet< Course >();

	// 学生的名字
	private String name;

	// 无参数的构造方法
	public Student() {

	}

	// 通过构造方法为属性赋值
	public Student( String name ) {

		this.name = name;
	}

	/**
	 * 给学生添加一门课程
	 *
	 * @param c 要添加给学生的课程
	 */
	public void addCourse( Course c ) {

		hashSet.add( c );
	}

	/**
	 * 通过指定的名称删除一门课程
	 *
	 * @param name 要删除的课程的名称,是String类型的
	 */
	public void removeCourse( String name ) {

		Course course = new Course( name );
		if ( hashSet.contains( course ) ) {

			hashSet.remove( course );
		}
	}

	// 返回用来储存课程的集合
	public Set< Course > getSet() {

		return hashSet;
	}

	// 返回学生总课程数
	public int countCourse() {

		return hashSet.size();
	}

	// 覆盖toString()方法
	public String toString() {

		return "学生名字：" + name;
	}

	// 覆盖hashCode()方法
	public int hashCode() {

		return ( this.name.hashCode() ) * 31;
	}


	// 覆盖equals()方法
	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj instanceof Student ) {

			Student s = (Student) obj;
			return this.name.equals( s.name );
		}

		return false;
	}

}
