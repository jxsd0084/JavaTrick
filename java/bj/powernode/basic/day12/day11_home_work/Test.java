package bj.powernode.basic.day12.day11_home_work;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 初始化一个学生
		Student s = new Student( "s_001", "jack" );





		// 初始化几门课程
		Course c1 = new Course( "c_001", "java" );
		Course c2 = new Course( "c_002", "oracle" );
		Course c3 = new Course( "c_003", "mysql" );
		Course c4 = new Course( "c_004", "db2" );
		Course c5 = new Course( "c_005", "c++" );
		Course c6 = new Course( "c_005", "c++" );




		// 学生选课
		s.addCourse( c1 );
		s.addCourse( c2 );
		s.addCourse( c3 );
		s.addCourse( c4 );
		s.addCourse( c5 );
		s.addCourse( c6 );





		// 取消课程
		s.deleteCourse( "mysql" );
		s.deleteCourse( "语文" );




		// 打印学生选课列表
		s.printCourseList();

	}

}
