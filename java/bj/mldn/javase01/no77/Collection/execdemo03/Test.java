package bj.mldn.javase01.no77.Collection.execdemo03;

import java.util.Iterator;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Course  c1   = new Course( "Java", 5 );
		Course  c2   = new Course( "Oracle", 3 );
		Student stu1 = new Student( "张三", 20 );
		Student stu2 = new Student( "李四", 21 );
		Student stu3 = new Student( "王五", 22 );
		Student stu4 = new Student( "赵六", 23 );
		Student stu5 = new Student( "孙七", 24 );
		Student stu6 = new Student( "钱八", 25 );

		// 以下是设置第一门课程的关系
		c1.getAllStudents().add( stu1 );
		c1.getAllStudents().add( stu3 );
		c1.getAllStudents().add( stu5 );
		stu1.getAllCourses().add( c1 );
		stu3.getAllCourses().add( c1 );
		stu5.getAllCourses().add( c1 );

		// 以下是设置第一门课程的关系
		c2.getAllStudents().add( stu1 );
		c2.getAllStudents().add( stu2 );
		c2.getAllStudents().add( stu3 );
		c2.getAllStudents().add( stu4 );
		c2.getAllStudents().add( stu5 );
		c2.getAllStudents().add( stu6 );
		stu1.getAllCourses().add( c2 );
		stu2.getAllCourses().add( c2 );
		stu3.getAllCourses().add( c2 );
		stu4.getAllCourses().add( c2 );
		stu5.getAllCourses().add( c2 );
		stu6.getAllCourses().add( c2 );

		// 输出一门课程和参加的学生
		System.out.println( c1 );
		Iterator< Student > iter1 = c1.getAllStudents().iterator();
		while ( iter1.hasNext() ) {
			System.out.println( "\t|- " + iter1.next() );
		}

		// 输出一个学生和所参与的课程
		System.out.println( stu1 );
		Iterator< Course > iter2 = stu1.getAllCourses().iterator();
		while ( iter2.hasNext() ) {
			System.out.println( "\t|- " + iter2.next() );
		}
	}
}
