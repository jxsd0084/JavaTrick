package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._098_经理与员工的差异;

import java.util.Date;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Employee employee = new Employee();
		employee.setName( "Java" );
		employee.setSalary( 100 );
		employee.setBirthday( new Date() );

		Manager manager = new Manager();
		manager.setName( "明日科技" );
		manager.setSalary( 3000 );
		manager.setBirthday( new Date() );
		manager.setBonus( 2000 );

		System.out.println( "员工的姓名：" + employee.getName() );
		System.out.println( "员工的工资：" + employee.getSalary() );
		System.out.println( "员工的生日：" + employee.getBirthday() );
		System.out.println( "经理的姓名：" + manager.getName() );
		System.out.println( "经理的工资：" + manager.getSalary() );
		System.out.println( "经理的生日：" + manager.getBirthday() );
		System.out.println( "经理的奖金：" + manager.getBonus() );

	}

}
