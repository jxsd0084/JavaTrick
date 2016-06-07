package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._116_简化compareTo方法的重写;

import java.util.Arrays;

public class Test {

	public static void main( String[] args ) {

		Employee   employee1 = new Employee( 3, "Java", 1 );
		Employee   employee2 = new Employee( 2, "PHP", 2 );
		Employee   employee3 = new Employee( 1, "Ruby", 3 );
		Employee   employee4 = new Employee( 1, "Ruby", 4 );
		Employee[] employees = new Employee[ 4 ];
		employees[ 0 ] = employee1;
		employees[ 1 ] = employee2;
		employees[ 2 ] = employee3;
		employees[ 3 ] = employee4;
		System.out.println( "排序前：" );
		for ( Employee employee : employees ) {
			System.out.println( employee );
		}
		System.out.println( "排序后：" );
		Arrays.sort( employees );
		for ( Employee employee : employees ) {
			System.out.println( employee );
		}
	}
}
