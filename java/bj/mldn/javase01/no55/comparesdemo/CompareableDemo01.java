package bj.mldn.javase01.no55.comparesdemo;

import java.util.Arrays;

class Student1 implements Comparable< Student1 > { // 实现比较器，并指定泛型

	private int    stuno;
	private String name;
	private int    age;
	private float  score;

	public Student1( int stuno, String name, int age, float score ) {

		this.stuno = stuno;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public int compareTo( Student1 stu ) {

		if ( this.score > stu.score ) {
			return - 1;

		} else if ( this.score < stu.score ) {
			return 1;

		} else {
			if ( this.age > stu.age ) {
				return 1;

			} else if ( this.age < stu.age ) {
				return - 1;

			} else {
				return 0;
			}
		}
	}

	public String toString() { // 覆写toString()
		return "学生编号：" + this.stuno + "；姓名：" + this.name + "；年龄：" + this.age
		       + "；成绩：" + this.score;
	}

}

public class CompareableDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Student1 stu[] = {
				new Student1( 1, "张三", 21, 99.1f ),
				new Student1( 2, "李四", 20, 99.1f ),
				new Student1( 3, "王五", 21, 89.1f ),
				new Student1( 4, "赵六", 21, 80.1f ),
				new Student1( 5, "孙七", 19, 80.1f )
		};

		System.out.println( "============== 数组声明之前 ===============" );

		print( stu );

		System.out.println( "============== 数组排序之后 ===============" );

		Arrays.sort( stu );// 排序

		print( stu );

	}

	public static void print( Student1 stu[] ) {

		for ( int i = 0; i < stu.length; i++ ) {

			System.out.println( stu[ i ] );
		}

	}

}
