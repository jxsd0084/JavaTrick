package bj.powernode.basic.day11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {


		// 1.创建集合
		List courses = new ArrayList();


		// 2.准备对象
		Course c1 = new Course( "001", "java" );
		Course c2 = new Course( "002", "vb" );
		Course c3 = new Course( "003", "oracle" );
		Course c4 = new Course( "004", "mysql" );
		Course c5 = new Course( "005", "struts" );


		// 3.添加元素
		courses.add( c1 );
		courses.add( c2 );
		courses.add( c3 );
		courses.add( c4 );
		courses.add( c5 );


		// 4.遍历集合
		Iterator it = courses.iterator();
		while ( it.hasNext() ) {

			Object obj = it.next();

			if ( obj instanceof Course ) {
				Course c = (Course) obj;

				if ( c.getC_name().equals( "oracle" ) ) {
					it.remove();
				}
			}

			System.out.println( obj.toString() );
		}

		System.out.println( "=============================================" );

		// 5.再次遍历
		Iterator it1 = courses.iterator();  // 如果再次遍历,需要获取新的迭代器对象.
		while ( it1.hasNext() ) {

			Object obj = it1.next();

			System.out.println( obj.toString() );
		}
	}

}


class Course {

	private String c_no;
	private String c_name;


	public Course() {

		super();
	}

	public Course( String cNo, String cName ) {

		super();
		c_no = cNo;
		c_name = cName;
	}


	public String getC_no() {

		return c_no;
	}

	public void setC_no( String cNo ) {

		c_no = cNo;
	}

	public String getC_name() {

		return c_name;
	}

	public void setC_name( String cName ) {

		c_name = cName;
	}


	public boolean equals( Object obj ) {

		if ( obj == null ) {

			return false;
		}
		if ( obj instanceof Course ) {

			Course c = (Course) obj;

			if ( this.getC_no().equals( c.getC_no() ) && this.getC_name().equals( c.getC_name() ) ) {

				return true;
			}
		}

		return false;
	}

	public int hashCode() {

		return this.getC_no().hashCode() + this.getC_name().hashCode();
	}

	public String toString() {

		return "Course [c_name=" + c_name + ", c_no=" + c_no + "]";
	}

}
