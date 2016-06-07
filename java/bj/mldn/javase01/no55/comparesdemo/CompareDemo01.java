package bj.mldn.javase01.no55.comparesdemo;

import java.util.Arrays;

class Student2 {

	private int    stuno;
	private String name;
	private int    age;
	private float  score;

	public Student2( int stuno, String name, int age, float score ) {

		this.stuno = stuno;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String toString() { // 覆写toString()
		return "学生编号：" + this.stuno + "；姓名：" + this.name + "；年龄：" + this.age
		       + "；成绩：" + this.score;
	}

}

public class CompareDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student2 stu[] = {
				new Student2( 1, "张三", 21, 99.1f ),
				new Student2( 2, "李四", 20, 99.1f ),
				new Student2( 3, "王五", 21, 89.1f ),
				new Student2( 4, "赵六", 21, 80.1f ),
				new Student2( 5, "孙七", 19, 80.1f )
		};

		System.out.println( "============== 数组声明之前 ===============" );

		print( stu );

		System.out.println( "============== 数组排序之后 ===============" );

		Arrays.sort( stu );// 排序

		print( stu );

	}

	public static void print( Student2 stu[] ) {

		for ( int i = 0; i < stu.length; i++ ) {

			System.out.println( stu[ i ] );
		}
	}
}


