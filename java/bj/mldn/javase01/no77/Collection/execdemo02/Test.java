package bj.mldn.javase01.no77.Collection.execdemo02;

import java.util.Iterator;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		School  school = new School( "MLDN" );
		Student stu1   = new Student( "张三", 23 );
		Student stu2   = new Student( "李四", 25 );
		Student stu3   = new Student( "王五", 22 );
		school.getAllStudents().add( stu1 ); // 一个学校有多个学生
		stu1.setSchool( school );            // 一个学生属于一个学校
		school.getAllStudents().add( stu2 ); // 一个学校有多个学生
		stu2.setSchool( school );            // 一个学生属于一个学校
		school.getAllStudents().add( stu3 ); // 一个学校有多个学生
		stu3.setSchool( school );            // 一个学生属于一个学校
		System.out.println( school );
		Iterator< Student > iter = school.getAllStudents().iterator();
		while ( iter.hasNext() ) {
			System.out.println( "\t|- " + iter.next() );
		}
	}

}
