package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._112_序列化与对象克隆;

public class Test112 {

	public static void main( String[] args ) {

		System.out.println( "克隆之前：" );

		Address112  address   = new Address112( "中国", "吉林", "长春" );
		Employee112 employee1 = new Employee112( "明日科技", 12, address );
		System.out.println( "员工1的信息：" );
		System.out.println( employee1 );
		System.out.println( "克隆之后：" );

		Employee112 employee2 = employee1.clone();
		employee2.getAddress().setState( "中国" );
		employee2.getAddress().setProvince( "四川" );
		employee2.getAddress().setCity( "成都" );
		employee2.setName( "西南交通大学" );
		employee2.setAge( 114 );

		System.out.println( "员工2的信息：" );
		System.out.println( employee2 );
		System.out.println( "员工1的信息：" );
		System.out.println( employee1 );

	}

}
