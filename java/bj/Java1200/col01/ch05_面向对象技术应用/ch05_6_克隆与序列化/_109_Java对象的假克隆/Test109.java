package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._109_Java对象的假克隆;

public class Test109 {

	public static void main( String[] args ) {

		System.out.println( "克隆之前：" );

		Employee109 employee1 = new Employee109();
		employee1.setName( "明日科技" );
		employee1.setAge( 12 );
		System.out.println( "员工1的信息：" );
		System.out.println( employee1 );
		System.out.println( "克隆之后：" );

		Employee109 employee2 = employee1;
		employee2.setName( "西南交通大学" );
		employee2.setAge( 114 );
		System.out.println( "员工2的信息：" );
		System.out.println( employee2 );
		System.out.println( "员工1的信息：" );
		System.out.println( employee1 );

	}

}
