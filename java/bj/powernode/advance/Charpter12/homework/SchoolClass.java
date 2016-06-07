package bj.powernode.advance.Charpter12.homework;

import java.util.HashSet;
import java.util.Set;

/*

	定义一个类SchoolClass代表班级，该类中包含一个
    属性是一个HashSet的对象，用来存储该班级中所有
    的Student,并提供相应的addStudent(Student s)方
    法和removeStudent(String name)方法，表示添加一
    名学生和删除一名学生

    （删除学生时通过传学生姓名参数来确定）。

*/
public class SchoolClass {

	// 用来储存学生的集合
	private Set< Student > hashSet;

	// 班级的名字
	private String className;

	{
		hashSet = new HashSet< Student >();
	}

	// 无参数的构造方法
	public SchoolClass() {

	}

	// 通过构造方法为属性赋值
	public SchoolClass( String className ) {

		this.className = className;
	}

	// 添加一学生的方法
	public void addStudent( Student s ) {

		hashSet.add( s );
	}

	// 删除一个学生的方法
	public void removeStudent( String name ) {

		//班级的学生
		Student stu = new Student( name );

		if ( hashSet.contains( stu ) ) {

			hashSet.remove( stu );
		}
	}

	// 返回用来储存课程的集合
	public Set< Student > getSet() {

		return hashSet;
	}

	// 返回班级总学生数
	public int countCourse() {

		return hashSet.size();
	}


	// 覆盖toString()方法
	public String toString() {

		return "班级名字：" + className;
	}

	//覆盖hashCode()方法
	public int hashCode() {

		return ( this.className.hashCode() ) * 31;
	}


	//覆盖equals()方法
	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj instanceof SchoolClass ) {

			SchoolClass s = (SchoolClass) obj;
			return this.className.equals( s.className );
		}

		return false;
	}

}
