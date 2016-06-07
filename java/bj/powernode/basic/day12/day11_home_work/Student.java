package bj.powernode.basic.day12.day11_home_work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {

	// 属性
	private String stu_no;
	private String stu_name;

	// Set集合中将来存储的元素是Course对象,重写Course的hashCode和equals方法.

	private Set courses = new HashSet(); // 推荐使用Set类型的集合存储Course对象,保证学生选课的不重复.


	// 构造方法
	public Student() {

		super();
	}

	public Student( String stu_no, String stu_name ) {

		this.stu_no = stu_no;
		this.stu_name = stu_name;
	}


	// setter and getter
	public void setStu_no( String stu_no ) {

		this.stu_no = stu_no;
	}

	public String getStu_no() {

		return stu_no;
	}

	public void setStu_name( String stu_name ) {

		this.stu_name = stu_name;
	}

	public String getStu_name() {

		return stu_name;
	}

	public void setCourses( Set courses ) {

		this.courses = courses;
	}

	public Set getCourses() {

		return courses;
	}


	// 重写hashCode
	public int hashCode() {

		return stu_no.hashCode() + stu_name.hashCode();
	}


	// 重写equals
	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Student ) {

			Student s = (Student) obj;

			if ( s.getStu_no().equals( this.stu_no ) && s.getStu_name().equals( this.stu_name ) ) {

				return true;
			}
		}

		return false;
	}


	// 重写toString
	public String toString() {

		return "[学生编号:" + stu_no + ",学生姓名:" + stu_name + "]";
	}


	// 学生对象选课的方法
	public void addCourse( Course c ) {
		
		/*
		// 遍历集合
		Iterator it = this.getCourses().iterator();
		while(it.hasNext()){

			Object obj = it.next();  // obj是集合中的元素.

			if(obj.equals(c)){

				System.out.println("课程"+c.toString()+"已被"+ this.getStu_name() +"学生选择,不能重复选择.");

				return ; // 结束程序
			}
		}
		*/

		if ( this.getCourses().add( c ) ) {

			System.out.println( "学生 " + this.getStu_name() + "选" + c.toString() + "成功" );

			return;
		}

		System.out.println( "课程" + c.toString() + "已被" + this.getStu_name() + "学生选择,不能重复选择." );

	}


	// 根据课程的名字删除课程
	public void deleteCourse( String courseName ) {

		// 遍历集合
		Iterator it = this.getCourses().iterator();
		while ( it.hasNext() ) {

			Object obj = it.next();

			if ( obj instanceof Course ) {

				Course c = (Course) obj;

				if ( c.getCname().equals( courseName ) ) {

					// 删除课程
					it.remove();

					System.out.println( "学生" + this.getStu_name() + "取消" + courseName + "课程成功." );

					return;
				}
			}

		}

		// courseName课程根本就没有选择.
		System.out.println( "学生" + this.getStu_name() + "没有选择" + courseName + "课程,取消课程失败." );

	}


	// 打印课程列表
	public void printCourseList() {

		System.out.println( "学生" + this.getStu_name() + "选课如下：" );


		// 遍历集合
		Iterator it = this.getCourses().iterator();
		while ( it.hasNext() ) {

			Object obj = it.next();

			if ( obj instanceof Course ) {

				Course c = (Course) obj;

				System.out.println( "\t" + c.toString() );
			}

		}

	}


}
