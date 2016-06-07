package bj.powernode.advance.Charpter12.homework;

/*
 在主方法中生成一个SchoolClass对象，添加若干个
 学生，并且为每个学生添加若干门课程，最后要统计
 出每门课程的选课人数。
 */
public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建一个班级
		SchoolClass sc = new SchoolClass( "JAVA就业班" );

		// 创建若干个学生
		Student s1 = new Student( "张一" );
		Student s2 = new Student( "张二" );
		Student s3 = new Student( "张三" );
		Student s4 = new Student( "张四" );
		Student s5 = new Student( "张五" );
		Student s6 = new Student( "张六" );

		// 创建若干门课程
		Course c1 = new Course( "JAVA基础" );
		Course c2 = new Course( "oracle" );
		Course c3 = new Course( "JSP" );
		Course c4 = new Course( "HTML" );
		Course c5 = new Course( "CSS" );

		// 给学生添加课程
		s1.addCourse( c1 );
		s1.addCourse( c2 );
		s1.addCourse( c3 );
		s1.addCourse( c4 );
		s1.addCourse( c5 );
		s2.addCourse( c5 );
		s2.addCourse( c3 );
		s2.addCourse( c2 );
		s3.addCourse( c2 );
		s3.addCourse( c4 );
		s3.addCourse( c1 );
		s4.addCourse( c2 );
		s4.addCourse( c4 );
		s4.addCourse( c1 );
		s5.addCourse( c2 );
		s5.addCourse( c4 );
		s5.addCourse( c1 );

		s6.addCourse( c3 );
		s6.addCourse( c4 );
		s6.addCourse( c5 );

		// 给班级添加学生
		sc.addStudent( s1 );
		sc.addStudent( s2 );
		sc.addStudent( s3 );
		sc.addStudent( s4 );
		sc.addStudent( s5 );
		sc.addStudent( s6 );

		// 统计出每门课程的选课人数
		CountCourse cc = new CountCourse( sc );
		int         i  = cc.count( "JAVA基础" );
		System.out.println( "JAVA基础课程的学习人数:" + i );

		i = cc.count( "oracle" );
		System.out.println( "oracle基础课程的学习人数:" + i );

		i = cc.count( "HTML" );
		System.out.println( "HTML基础课程的学习人数:" + i );

		i = cc.count( "CSS" );
		System.out.println( "CSS基础课程的学习人数:" + i );

		i = cc.count( "JSP" );
		System.out.println( "JSP基础课程的学习人数:" + i );

		// 删除s1的JAVA基础和oracle课程
		s1.removeCourse( "JAVA基础" );
		s1.removeCourse( "oracle" );




		System.out.println( "========================================" );





		// 统计出每门课程的选课人数
		i = cc.count( "JAVA基础" );
		System.out.println( "JAVA基础课程的学习人数:" + i );

		i = cc.count( "oracle" );
		System.out.println( "oracle基础课程的学习人数:" + i );

		i = cc.count( "HTML" );
		System.out.println( "HTML基础课程的学习人数:" + i );

		i = cc.count( "CSS" );
		System.out.println( "CSS基础课程的学习人数:" + i );

		i = cc.count( "JSP" );
		System.out.println( "JSP基础课程的学习人数:" + i );

	}

}
