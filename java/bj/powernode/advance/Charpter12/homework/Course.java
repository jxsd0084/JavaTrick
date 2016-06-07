package bj.powernode.advance.Charpter12.homework;


/*
 定义一个Course类，代表课程
 */
public class Course {

	// 课程名字
	private String courseName;

	// 无参数的构造方法
	public Course() {

	}

	// 通过构造方法为属性赋值
	public Course( String courseName ) {

		this.courseName = courseName;
	}

	/**
	 * 覆盖Course类的toString方法
	 *
	 * @return Course对象的String格式
	 */
	public String toString() {

		return "课程名：" + courseName;
	}

	/**
	 * 覆盖Course类的hashCode方法
	 *
	 * @return Course对象的hashCode值
	 */
	public int hashCode() {

		return ( this.courseName.hashCode() ) * 31;
	}


	// 覆盖equals()方法
	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj instanceof Course ) {

			Course c = (Course) obj;
			return this.courseName.equals( c.courseName );
		}

		return false;
	}

}
