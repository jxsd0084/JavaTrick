package bj.powernode.advance.Charpter12.homework;

import java.util.Iterator;

// 用来统计出每门课程的选课人数
public class CountCourse {

	// 班级的名字
	private SchoolClass className;

	// 无参数的构造
	public CountCourse() {

	}

	// 有参数的构造
	public CountCourse( SchoolClass className ) {

		this.className = className;
	}

	/**
	 * 统计指定课程的学习人数
	 *
	 * @param courseName 学习课程的名称
	 * @return 学习了该门课程的学生的人数
	 */
	public int count( String courseName ) {

		// 计算选课人数的指针
		int count = 0;
		// 循环班级里面的每个学生
		Iterator< Student > it = className.getSet().iterator();
		while ( it.hasNext() ) {

			Student stu = it.next();
			if ( stu.getSet().contains( new Course( courseName ) ) ) {

				count++;
			}
		}

		return count;
	}

}
